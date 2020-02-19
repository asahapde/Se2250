/* Authors: Abdullah Sahapdeen - Id: asahapde - Student Number: 251033977 and Mayank Sood - Id: msood - Student Number: 251000865
   Date Created: December 3, 2019
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI {

  static Graph graph = new Graph();
  static Boolean acceptValue = false;
  static int nodeNumber = 0;
  static ArrayList<Node> nodes = new ArrayList<Node>();
  static String value = "";
  static String sourceString = "";
  static String destinationString = "";

  public static void main(String[] args){


    JFrame frame = new JFrame("Assignment 3 Bonus");
    JPanel mainPanel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    JPanel inputPanel = new JPanel(new GridBagLayout());
    JPanel buttonPanel = new JPanel(new GridLayout(3,1,10,10));
    JPanel outputPanel = new JPanel();
    outputPanel.setLayout(new BoxLayout(outputPanel, BoxLayout.Y_AXIS));

    mainPanel.setBackground(Color.WHITE);
    inputPanel.setBackground(Color.WHITE);
    buttonPanel.setBackground(Color.WHITE);
    outputPanel.setBackground(Color.WHITE);


/////////////////////////////////////////////////////
    JRadioButton dfsButton = new JRadioButton();
    JRadioButton bfsButton = new JRadioButton();
    ButtonGroup algoGroup = new ButtonGroup();
    JLabel dfsLabel = new JLabel("DFS");
    JLabel bfsLabel = new JLabel("BFS");
    JLabel selectLabel = new JLabel("Select your algorithm");
    JButton runButton = new JButton("Run");

    algoGroup.add(dfsButton);
    algoGroup.add(bfsButton);


    c.fill = GridBagConstraints.BOTH;
    c.insets = new Insets(10,10,10,10);

    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 4;
    c.gridx = 0;
    c.gridy = 0;
    selectLabel.setHorizontalAlignment(JLabel.CENTER);
    inputPanel.add(selectLabel,c);

    c.weightx = 1/4;
    c.weighty = 1;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 1;
    dfsButton.setBackground(Color.WHITE);
    inputPanel.add(dfsButton,c);

    c.weightx = 1/4;
    c.weighty = 1;
    c.gridwidth = 1;
    c.gridx = 1;
    c.gridy = 1;
    inputPanel.add(dfsLabel,c);

    c.weightx = 1/4;
    c.weighty = 1;
    c.gridwidth = 1;
    c.gridx = 2;
    c.gridy = 1;
    bfsButton.setBackground(Color.WHITE);
    inputPanel.add(bfsButton,c);

    c.weightx = 1/4;
    c.weighty = 1;
    c.gridwidth = 1;
    c.gridx = 3;
    c.gridy = 1;
    inputPanel.add(bfsLabel,c);


    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 4;
    c.gridx = 0;
    c.gridy = 3;
    inputPanel.add(runButton,c);



//////////////////////////////////////////
    JButton nodeButton = new JButton("Add Node");
    JButton edgeButton = new JButton("Add Edge");
    JButton printButton = new JButton("Print Edges");

    nodeButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        GUI.addNodeGui();
      }
    });
    buttonPanel.add(nodeButton);

    edgeButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        GUI.addEdgeGui();
      }
    });
    buttonPanel.add(edgeButton);


    buttonPanel.add(printButton);
///////////////////////////////////////////
    JLabel resultLabel = new JLabel("Results");
    resultLabel.setAlignmentX(JLabel.LEFT_ALIGNMENT);
    JTextArea output = new JTextArea();
    JScrollPane outputPane = new JScrollPane( output);
    outputPane.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);

    output.setEditable(false);

    outputPanel.add(resultLabel);
    outputPanel.add(outputPane);

    printButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        output.setText("");
        output.setText(graph.printEdges());
      }
    });




//////////////////////////////////////////////
    c.weightx = 0.5;
    c.weighty = 0.5;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 0;
    mainPanel.add(inputPanel,c);

    c.weightx = 0.5;
    c.weighty = 0.5;
    c.gridwidth = 1;
    c.gridx = 1;
    c.gridy = 0;
    mainPanel.add(buttonPanel,c);

    c.weightx = 1;
    c.weighty = 0.5;
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 1;
    mainPanel.add(outputPanel,c);



//////////////////////////////////////////

runButton.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e)
  {
    output.setText("");
    for(int i =0; i < nodes.size();i++){
      nodes.get(i).unvisit();
    }
    if(dfsButton.isSelected()){
      output.setText(graph.DFS(nodes.get(0)));
      graph.dfsString = "";
      graph.printed = false;
    }
    else if(bfsButton.isSelected()){
      output.setText(graph.BFS(nodes.get(0)));
    }
  }
});


    frame.setContentPane(mainPanel);
    //System.out.print(frame.getContentPane());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,400);
    frame.setResizable(false);
    frame.setVisible(true);
  }

  public static Node[] addEdgeGui(){
    JFrame frame = new JFrame("Add Edge");
    JPanel mainPanel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    JLabel sourceLabel = new JLabel("Source");
    JLabel destinationLabel = new JLabel("Destination");
    JTextField source = new JTextField();
    JTextField destination = new JTextField();
    JButton addButton = new JButton("Add");

    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10,10,10,10);

    c.weightx = 0.5;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 0;
    mainPanel.add(sourceLabel,c);

    c.weightx = 0.5;
    c.gridwidth = 1;
    c.gridx = 1;
    c.gridy = 0;
    mainPanel.add(source,c);

    c.weightx = 0.5;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 1;
    mainPanel.add(destinationLabel,c);

    c.weightx = 0.5;
    c.gridwidth = 1;
    c.gridx = 1;
    c.gridy = 1;
    mainPanel.add(destination,c);

    addButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        sourceString=source.getText();
        destinationString=destination.getText();
        Node sourceNode = new Node(0,null);
        Node destinationNode = new Node(0,null);
        for(int i =0; i < nodes.size();i++){
          if(nodes.get(i).name.equals(sourceString)){
            sourceNode = nodes.get(i);
            //System.out.println("Source: " + nodes.get(i).name);
          }
          if(nodes.get(i).name.equals(destinationString)) {
            destinationNode = nodes.get(i);
            //System.out.println("Destination: " + nodes.get(i).name);
          }
        }
        System.out.println("Link added: " + sourceString + " to " + destinationString);

        source.setText("");
        destination.setText("");

        graph.addEdge(sourceNode,destinationNode);
      }
    });
    c.weightx = 1;
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 2;
    c.fill = GridBagConstraints.NONE;
    mainPanel.add(addButton,c);
    c.fill = GridBagConstraints.HORIZONTAL;


    frame.setContentPane(mainPanel);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(300,200);
    frame.setResizable(false);
    frame.setVisible(true);

    if(acceptValue) return null;
    else return null;
  };

  public static Node addNodeGui(){

    JFrame frame = new JFrame("Add Node");
    JPanel mainPanel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    JLabel nodeLabel = new JLabel("Node Name");
    JTextField node = new JTextField();
    JButton addButton = new JButton("Add");


    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(10,10,10,10);

    c.weightx = 0.5;
    c.gridwidth = 1;
    c.gridx = 0;
    c.gridy = 0;
    mainPanel.add(nodeLabel,c);


    c.weightx = 0.5;
    c.gridwidth = 1;
    c.gridx = 1;
    c.gridy = 0;
    mainPanel.add(node,c);


    addButton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
        value=node.getText();
        nodes.add(new Node(nodes.size(),value));
        System.out.println("Node added: " + value);
        node.setText("");
      }
    });
    c.weightx = 1;
    c.gridwidth = 2;
    c.gridx = 0;
    c.gridy = 1;
    c.fill = GridBagConstraints.NONE;
    mainPanel.add(addButton,c);
    c.fill = GridBagConstraints.HORIZONTAL;




    frame.setContentPane(mainPanel);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setSize(300,200);
    frame.setResizable(false);
    frame.setVisible(true);

    if(acceptValue) return null;
    else return null;
  }

}
