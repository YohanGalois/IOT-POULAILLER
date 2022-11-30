package io.univartois.cameldemo.routes;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Component
public class k extends RouteBuilder {
    @Override
    public void configure() throws IOException {
        String name = "NON";
        //from("direct:ind").to("exec:bash?args=./testScript.sh "+name).log("Hello0");
        if(name=="NON") {
            List<String> tables = List.of("poules", "iopoules", "humidite", "nourrgen", "nourbacglob", "lumiere", "temperature");
            for (String tab : tables
            ) {
                System.out.println(tab);
                String c = runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/deleteIndex.sh", tab);
                String d = runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/createIndex.sh", tab);
                System.out.println("" + c + d);
            }
        }
        LocalTime c=LocalTime.now();
        long time=c.getSecond();
        System.out.println(c);
        Random random = new Random();
        UuidGenerator f=new UuidGenerator();
        List<String> a=f.getUuid(0,100,0,10,0,10);
        List<String> list=a;
        System.out.println(a);

        from("timer:monSuperTimer?period=100")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        UuidGenerator f=new UuidGenerator();
                        List<String> a=f.getUuid(1,3000,1,3,30,9999);
                        List<String> list=a;
                        System.out.println(a.get(0));
                        runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/RemplirIndex.sh","poules",String.valueOf(a.get(0)),String.valueOf(a.get(1)),String.valueOf(a.get(2)));
                    }
                });
        from("timer:monSuperTimer?period=100")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        UuidGenerator f=new UuidGenerator();
                        List<String> a=f.getUuid(1,3000,1,999999999,-10,10);
                        List<String> list=a;
                        System.out.println(a.get(0));
                        runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/RemplirIndex.sh","iopoules",String.valueOf(a.get(0)),String.valueOf(a.get(1)),String.valueOf(a.get(2)));
                    }
                });
        from("timer:monSuperTimer?period=100")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        UuidGenerator f=new UuidGenerator();
                        List<String> a=f.getUuid(0,1,1,999,0,100);
                        List<String> list=a;
                        System.out.println(a.get(0));
                        runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/RemplirIndex.sh","humidite",String.valueOf(a.get(0)),String.valueOf(a.get(1)),String.valueOf(a.get(2)));
                    }
                });

        from("timer:monSuperTimer?period=100")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        UuidGenerator f=new UuidGenerator();
                        List<String> a=f.getUuid(0,1,0,500,0,10000);
                        List<String> list=a;
                        System.out.println(a.get(0));
                        runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/RemplirIndex.sh","nourrgen",String.valueOf(a.get(0)),String.valueOf(a.get(1)),String.valueOf(a.get(2)));
                    }
                });
        from("timer:monSuperTimer?period=100")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        UuidGenerator f=new UuidGenerator();
                        List<String> a=f.getUuid(0,1,0,10,0,10000);
                        List<String> list=a;
                        System.out.println(a.get(0));
                        runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/RemplirIndex.sh","nourbacglob",String.valueOf(a.get(0)),String.valueOf(a.get(1)),String.valueOf(a.get(2)));
                    }
                });

        from("timer:monSuperTimer?period=100")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        UuidGenerator f=new UuidGenerator();
                        List<String> a=f.getUuid(0,1,0,10000,-1,120000);
                        List<String> list=a;
                        System.out.println(a.get(0));
                        runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/RemplirIndex.sh","lumiere",String.valueOf(a.get(0)),String.valueOf(a.get(1)),String.valueOf(a.get(2)));
                    }
                });

        from("timer:monSuperTimer?period=100")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        UuidGenerator f=new UuidGenerator();
                        List<String> a=f.getUuid(0,1,0,10000,-36,46);
                        List<String> list=a;
                        System.out.println(a.get(0));
                        runScript("/home/yohan/TECHEMERG/DOSSIER PROJET/scriptBash/RemplirIndex.sh","temperature",String.valueOf(a.get(0)),String.valueOf(a.get(1)),String.valueOf(a.get(2)));
                    }
                });

        }

    public static String runScript(String path, String... args) {
        String result="";
        try {
            String[] cmd = new String[args.length + 1];
            cmd[0] = path;
            int count = 0;
            for (String s : args) {
                cmd[++count] = args[count - 1];
            }
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            try {
                process.waitFor();
            } catch (Exception ex) {
                result=ex.getMessage();
                System.out.println(ex.getMessage());
            }
            while (bufferedReader.ready()) {
                result=bufferedReader.readLine();
                System.out.println("Received from script: " + bufferedReader.readLine());
            }
        } catch (Exception ex) {
            result=ex.getMessage();
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        return result;
    }

}
