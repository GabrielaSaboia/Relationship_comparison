
import java.io.*;

import java.util.*;
import java.util.StringTokenizer;
/*
 * Please find the codes of functions below. Please add it into your java class
 * and call these functions yourself. Note that it cannot run directly by just
 * putting these into a java file! A little bit more effort is needed.
*/


public class FindEdges {

    private void writeData(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        //write information begin
        for (int i = 0; i < 10; i++) {
            bw.write(i + "\n");
        }
        //write information end
        bw.close();
    }

    private ArrayList readData(String filename) throws FileNotFoundException, IOException {
        ArrayList information = new ArrayList();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;

        //read information begin
        while ((line = br.readLine()) != null) {
            String lineHolder = line;
            information.add(lineHolder);
            System.out.println(information.get(information.size() - 1));
        }

        //read information end

        //Changed the function to return an Array List with all the lines from the file
        return information;
    }

    private void loadInformation(String filename) throws FileNotFoundException, IOException {
        ArrayList nodeName = new ArrayList();
        int[][] relationship = new int[1][1];

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        Boolean getNodeInformation = false;
        Boolean getRelationshipInformation = false;

        //begin read information
        while ((line = br.readLine()) != null) {
            if (line.startsWith("*")) {// change the control parameter
                if (line.startsWith("*Vertices")) {
                    getNodeInformation = true;
                    getRelationshipInformation = false;
                }
                if (line.startsWith("*Edges")) {
                    getNodeInformation = false;
                    getRelationshipInformation = true;
                    relationship =
                            new int[nodeName.size()][nodeName.size()];
                }
            } else {//update the related parameter
                if (getNodeInformation) {
                    String name =
                            line.substring(line.indexOf(" ") + 1);
                    nodeName.add(name);
                }
                if (getRelationshipInformation) {
                    String[] index = line.split(" ");
                    relationship[Integer.parseInt(index[0]) - 1]
                            [Integer.parseInt(index[1]) - 1] = 1;
                    relationship[Integer.parseInt(index[1]) - 1]
                            [Integer.parseInt(index[0]) - 1] = 1;
                }
            }
        }
        //end read information

        for (int i = 0; i < nodeName.size(); i++) {
            System.out.print("," + nodeName.get(i));
        }
        System.out.print("\n");

        for (int i = 0; i < nodeName.size(); i++) {
            System.out.print(nodeName.get(i).toString());
            for (int j = 0; j < nodeName.size(); j++) {
                System.out.print("," + relationship[i][j]);
            }
            System.out.print("\n");
        }
    }




    public static void main(String[] args) {

        String fn = new String("/Users/gabrielasaboia/IdeaProjects/Assignment2/src/friendship.txt");
        FindEdges fe = new FindEdges();
        ArrayList dataIn = new ArrayList();
        Iterator itr = dataIn.iterator();

       /*try {
            fe.loadInformation(fn);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        try {
            dataIn = fe.readData(fn);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dataIn);

        //Object vertices = dataIn.get(0);


        /*
        String[] spliter = vertices.toString().split(",");


        System.out.println(spliter.getClass());

        ListIterator litr = spliter.listIterator();

        while(litr.hasNext()){
            Object element = litr.next();

            litr.set("*vertices " + element);
            break;
        }
        System.out.println("Modified List: ");
        itr = dataIn.iterator();

        while(itr.hasNext()) {
            Object element = itr.next();
            System.out.print(element + " ");

        }

         */


    }

}

