package ua.kpi.telegram.opencart.telegramopencart.config;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.BaseResponse;

public class Example {
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("537738367:AAH3rGn4OR3S5KKIZ2ZU5xTaoPYVAspBsvk");

        //GetChat getChat = new GetChat(new Integer("32652404"));


        BaseRequest request = new SendMessage(32652404, "test");

        BaseResponse response = bot.execute(request);


        System.out.println(response.isOk());
    }

}