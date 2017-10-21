package watsonApp.Controllers;

import com.github.messenger4j.MessengerPlatform;
import com.github.messenger4j.exceptions.MessengerApiException;
import com.github.messenger4j.exceptions.MessengerIOException;
import com.github.messenger4j.exceptions.MessengerVerificationException;
import com.github.messenger4j.receive.MessengerReceiveClient;
import com.github.messenger4j.receive.handlers.FallbackEventHandler;
import com.github.messenger4j.receive.handlers.PostbackEventHandler;
import com.github.messenger4j.receive.handlers.QuickReplyMessageEventHandler;
import com.github.messenger4j.receive.handlers.TextMessageEventHandler;
import com.github.messenger4j.send.MessengerSendClient;
import com.github.messenger4j.send.NotificationType;
import com.github.messenger4j.send.Recipient;
import com.github.messenger4j.send.buttons.Button;
import com.github.messenger4j.send.templates.ButtonTemplate;
import com.ibm.watson.developer_cloud.conversation.v1.Conversation;
import com.ibm.watson.developer_cloud.conversation.v1.model.InputData;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageOptions;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import watsonApp.Beans.Account;
import watsonApp.Entities.MessageContainer;
import watsonApp.Services.AccountService;
import watsonApp.Services.ChatBotService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.github.messenger4j.MessengerPlatform.*;

/**
 * Created by jfink on 20/10/17.
 */

@RestController
public class MessengerController {

    @Autowired
    ChatBotService chatBotService;

    @Autowired
    AccountService account;

    private final MessengerReceiveClient receiveClient;
    private final MessengerSendClient sendClient;

    @Autowired
    public MessengerController(@Value("${messenger4j.appSecret}") final String appSecret,
                               @Value("${messenger4j.verifyToken}") final String verifyToken,
                               final MessengerSendClient sendClient){

        this.receiveClient = MessengerPlatform.newReceiveClientBuilder(appSecret, verifyToken)
                .onTextMessageEvent(newTextMessage())
                .onPostbackEvent(newPostbackEventHandler())
                .fallbackEventHandler(newFallbackEventHandler())
                .build();

        this.sendClient = sendClient;
    }

    /**
     * Callback endpoint responsible for processing the inbound messages and events.
     */
    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    public ResponseEntity<Void> handleCallback(@RequestBody final String payload,
                                               @RequestHeader(SIGNATURE_HEADER_NAME) final String signature) {

        try {
            this.receiveClient.processCallbackPayload(payload, signature);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (MessengerVerificationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }


    public TextMessageEventHandler newTextMessage(){
        return event->{
            final String messageId = event.getMid();
            final String messageText = event.getText();
            final String senderId = event.getSender().getId();
            final Date timestamp = event.getTimestamp();


            watsonHandle(senderId, messageText);
        };
    }


    private void sendButtonMessage(String recipientId) throws MessengerApiException, MessengerIOException {
        final List<Button> buttons = Button.newListBuilder()
                .addPostbackButton("Account 1", "1").toList()
                .addPostbackButton("Account 2", "2").toList()
                .addPostbackButton("Account 3", "3").toList()
                .build();

        final ButtonTemplate buttonTemplate = ButtonTemplate.newBuilder("Which account", buttons).build();
        this.sendClient.sendTemplate(recipientId, buttonTemplate);
    }

    private void sendTextMessage(String recipientId, String text) {
        try {
            final Recipient recipient = Recipient.newBuilder().recipientId(recipientId).build();
            final NotificationType notificationType = NotificationType.REGULAR;
            final String metadata = "DEVELOPER_DEFINED_METADATA";

            this.sendClient.sendTextMessage(recipient, notificationType, text, metadata);
        } catch (MessengerApiException | MessengerIOException e) {
            System.out.printf("Oups");
        }
    }

    private void sendGifMessage(String recipientId) throws MessengerApiException, MessengerIOException {
        this.sendClient.sendImageAttachment(recipientId, " https://media.giphy.com/media/l46CjoMYO5n2hQnWE/giphy.gif");
    }

    /**
     * Webhook verification endpoint.
     *
     * The passed verification token (as query parameter) must match the configured verification token.
     * In case this is true, the passed challenge string must be returned by this endpoint.
     */
    @RequestMapping(value = "/webhook", method = RequestMethod.GET)
    public ResponseEntity<String> verifyWebhook(@RequestParam(MODE_REQUEST_PARAM_NAME) final String mode,
                                                @RequestParam(VERIFY_TOKEN_REQUEST_PARAM_NAME) final String verifyToken,
                                                @RequestParam(CHALLENGE_REQUEST_PARAM_NAME) final String challenge) {

        try {
            return ResponseEntity.ok(this.receiveClient.verifyWebhook(mode, verifyToken, challenge));
        } catch (MessengerVerificationException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @RequestMapping("/messenger")
    public String test(){
        chatBotService.getChatbotResponse("Hello");

        return "bleh";
    }


    private PostbackEventHandler newPostbackEventHandler() {
        return event -> {

            final String senderId = event.getSender().getId();
            final String recipientId = event.getRecipient().getId();
            final String payload = event.getPayload();
            final Date timestamp = event.getTimestamp();

            sendTextMessage(senderId, payload);
        };
    }


    /**
     * This handler is called when either the message is unsupported or when the event handler for the actual event type
     * is not registered. In this showcase all event handlers are registered. Hence only in case of an
     * unsupported message the fallback event handler is called.
     */
    private FallbackEventHandler newFallbackEventHandler() {
        return event -> {
            final String senderId = event.getSender().getId();
        };
    }

    public void watsonHandle(String recipientId, String message){

        MessageContainer mc = chatBotService.getChatbotResponse(message);

        if(mc.getType().equals("button")){

        }

        if(mc.getType().equals("default")){
            sendTextMessage(recipientId, mc.getText());
            return;
        }

        sendTextMessage(recipientId, "Case not handled : " + mc.getType());
    }




    public void handleButtonCase(String recipientID, MessageContainer mc){

        if(mc.getContainer().equals("listAccount")){
            //Fetching all the account
            ArrayList<Account> accList = account.getAccounts(account.getClient(recipientID));

        }
    }
}
