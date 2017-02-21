package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class GreetingController {


    @Autowired
    private SimpMessagingTemplate template;


    @MessageMapping("/notification")
    @SendTo("/topic/cart")
    public PopupMessage greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new PopupMessage("Hello, " + message.getName() + "!");
    }


    // way 1: working
    @RequestMapping("/message/notification")
    @ResponseBody
    public String sayHello(HelloMessage message) {
        //  template.convertAndSend("/topic/cart", new Greeting(message.getName()));
        message = new HelloMessage("email");
        template.convertAndSend("/topic/cart", new PopupMessage("from rest" + message.getName() + "  $$"));
        return "from rest";
    }
    // way 1: working

    @RequestMapping(method = RequestMethod.POST, value = "/message/address", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String bulkData(@RequestBody AddressBulkUpload addressBulkUpload) {
        AddressBulkUpload result = null;
        result = addressBulkUpload;
        template.convertAndSend("/topic/cart", new PopupMessage(result.toString()));
        return "successful";
    }
}
 /*
   public Greeting sayHello(HelloMessage message){
        template.convertAndSend("/topic/cart", new Greeting(message.getName()));
        return new Greeting("Hello, " + message.getName() + "!");
    }*/

// way 2 : checking
   /* @MessageMapping("/notification")
    @SendTo("/topic/cart")
    @RequestMapping("/message/notification")
    @ResponseBody
    public String sayHello(HelloMessage message){
      //  template.convertAndSend("/topic/cart", new Greeting(message.getName()));
        return message.getName();
    }*/

