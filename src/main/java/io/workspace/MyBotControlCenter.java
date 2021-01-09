package io.workspace;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBotControlCenter extends TelegramLongPollingBot {

    private String name="",price,;


    public String getBotUsername() {
        return "smartfon_va_noutbuklar_bot";
    }

    public String getBotToken() {
        return "1497734938:AAEAX_xEBXG-NpDG5AihMX_9hl_l0xgfglE";
    }

    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            message.get
            if (message.hasText()){
                String text = message.getText();
                if (text.equals("/start")){
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Siz nimani sotmoqchisiz quyidagi ro'yxatdan tanlang:");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));

                    InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtonList1 = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtonList2 = new ArrayList<>();
                    InlineKeyboardButton inlineKeyboardButton_smartfon = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton_noutbuk = new InlineKeyboardButton();
                    inlineKeyboardButton_smartfon.setText("Smartfon");
                    inlineKeyboardButton_noutbuk.setText("Noutbuk");
                    inlineKeyboardButton_smartfon.setCallbackData("smartfon");
                    inlineKeyboardButton_noutbuk.setCallbackData("noutbuk");
                    inlineKeyboardButtonList1.add(inlineKeyboardButton_smartfon);
                    inlineKeyboardButtonList2.add(inlineKeyboardButton_noutbuk);
                    inlineButtons.add(inlineKeyboardButtonList1);
                    inlineButtons.add(inlineKeyboardButtonList2);
                    inlineKeyboardMarkup.setKeyboard(inlineButtons);
                    sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (update.hasCallbackQuery()){
            Message message = update.getCallbackQuery().getMessage();
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data = callbackQuery.getData();
            System.out.println(message.getChatId());
            SendMessage sendMessage = new SendMessage().setParseMode(ParseMode.HTML).setChatId((long) 1093999329);
            SendMessage sendMessage1 = new SendMessage().setParseMode(ParseMode.HTML).setChatId(message.getChatId());
            if (data.equals("smartfon")){
                sendMessage.setText("Smartfon nomini va parametrlarini kiriting, masalan :\n" +
                        "<b><i>Samsung A51</i> (4/64)</b>");
                sendMessage1.setText("Smartfon nomini va parametrlarini kiriting, masalan :\n" +
                        "<b><i>Samsung A51</i> (4/64)</b>");
            } else if (data.equals("noutbuk")){
                sendMessage.setText("Noutbuk nomini va parametrlarini kiriting, masalan:\n" +
                        "<b>Acer aspire 3</b>\n<i>(i5 10th/8gb DDR4/256gb SSD)</i>");
                sendMessage1.setText("Noutbuk nomini va parametrlarini kiriting, masalan:\n" +
                        "<b>Acer aspire 3</b>\n<i>(i5 10th/8gb DDR4/256gb SSD)</i>");
            }
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            try {
                execute(sendMessage1);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
