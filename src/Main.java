import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        try{

            String fileName=args[0];

            if(!fileName.endsWith(".arxml")) {
                throw new NotVaildAutosarFileException("Invalid Autosar File Exception");
            }

            File file=new File(fileName);
            FileInputStream inputStream =new FileInputStream(file);

            int n;
            StringBuilder stringBuilder=new StringBuilder();
            while((n=inputStream.read()) !=-1){
                stringBuilder.append((char) n);
            }

            String data=stringBuilder.toString();
            Scanner scanner=new Scanner(data);
            ArrayList<container> containers=new ArrayList<>();

            if(!scanner.hasNextLine()){
                System.out.println("empty file");
                return;
            }
            while(scanner.hasNextLine()){
                String line= scanner.nextLine();
                if(line.contains("<CONTAINER")){
                    String conid=line.substring(line.indexOf("UUID="),line.indexOf(">"));
                    String shname= scanner.nextLine();
                    String sh=shname.substring(shname.indexOf(">")+1,shname.indexOf("</"));
                    String lname= scanner.nextLine();
                    String l=lname.substring(lname.indexOf(">")+1,lname.indexOf("</"));
                    container cont= new container();
                    cont.setConID(conid);
                    cont.setShName(sh);
                    cont.setlName(l);
                    containers.add(cont);
                }
            }

            Collections.sort(containers);

            String outName=fileName.substring(0,fileName.indexOf("."))+"_mod.arxml";
            FileOutputStream outputStream =new FileOutputStream(outName);

            outputStream.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n".getBytes());
            outputStream.write("<AUTOSAR>\n".getBytes());

            for(int i=0;i<containers.size();i++){
                outputStream.write(containers.get(i).toString().getBytes());
            }

            outputStream.write("</AUTOSAR>".getBytes());
        } catch (NotVaildAutosarFileException e) {
            e=new NotVaildAutosarFileException("Not Valid");
        } catch (FileNotFoundException e) {
            e=new FileNotFoundException("File Not Found");
        } catch (IOException e) {
            e=new IOException("IO Exception");
        }

    }
}