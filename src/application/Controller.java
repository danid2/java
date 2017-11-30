package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Controller  {


   public Model model = new Model();




    @FXML
    public Button connectButton = new Button();
    @FXML
    public Button connectButton2 = new Button();


    @FXML
    public TextField host = new TextField("localhost");
    @FXML
    public TextField port = new TextField("11111");
    @FXML
    public TextField serverIP = new TextField();
    @FXML
    public TextField serverName = new TextField();
    @FXML
    public TextField client = new TextField();
    @FXML
    public TextField counter = new TextField();
    @FXML
    public TextField fail = new TextField();
    @FXML
    public TextField loopNumber = new TextField();


    @FXML
    public Label dockerLabel = new Label();
    @FXML
    public Label hostLabel = new Label();
    @FXML
    public Label portLabel = new Label();
    @FXML
    public Label serverIPLabel = new Label();
    @FXML
    public Label serverNameLabel = new Label();
    @FXML
    public Label clientLabel = new Label();
    @FXML
    public Label counterLabel = new Label();
    @FXML
    public Label failLabel = new Label();


    @FXML
    public HBox hostHbox = new HBox();
    @FXML
    public HBox portHbox = new HBox();
    @FXML
    public HBox serverIPHbox = new HBox();
    @FXML
    public HBox serverNameHbox = new HBox();
    @FXML
    public HBox clientHbox = new HBox();
    @FXML
    public HBox connectHbox = new HBox();
    @FXML
    public HBox counterHbox = new HBox();
    @FXML
    public HBox failHbox = new HBox();


    /**
     * View initialization, it will be called after view was prepared
     */
    @FXML
    public void initialize() {

        dockerLabel.setText(
                "                                                   |##|                                .- \n"+
                "                                   |##|  |##|  |##|                              /=| \n" +
                "                           |##|  |##|  |##|  |##|  |##|                    /==| \n" +
                "                 _____________________________________          /===\\ \n" +
                "               /                                                         \\____/ ====\\  \n" +
                "     ~~~ { ~~~ ~~~ ~~~ ~~~ ~~~ ~~~ ~~~ ~~~~   ===\\ ~~~ \n" +
                "               \\                  0                                        ___/    \\====\\ \n"  +
                "                 \\            __.                                    ___/        \n"+
                "                   \\_---\"\"     \\                            ___/ \n" +
                "                         \\_______\\________________/ \n");

        hostLabel.setText("host:");
        hostLabel.setWrapText(true);
        host.setText("localhost");

        portLabel.setText("port:");
        portLabel.setWrapText(true);
        port.setText("11111");

        serverIPLabel.setText("server IP:");
        serverIPLabel.setWrapText(true);
        serverNameLabel.setText("server name:");

        clientLabel.setText("client IP:port:");

        counterLabel.setText("connections served:");
        counterLabel.setWrapText(true);

        failLabel.setText("connections failed:");
        failLabel.setWrapText(true);
        loopNumber.setText("100");

    }




    public void connectEventHandler(ActionEvent actionEvent) {

        model.loop = Integer.parseInt(loopNumber.getText());
        model.connect(host.getText(), Integer.parseInt(port.getText()));
        serverIP.setText(model.ip);
        serverName.setText(model.remoteHostName);
        client.setText(model.clientIPAddr);
        counter.setText(model.success);
        fail.setText(String.valueOf(model.failure));

    }


    public void connect2EventHandler(ActionEvent actionEvent) {

        model.loop = Integer.parseInt(loopNumber.getText());
        Thread t = new Thread(model);
        t.start();
        serverIP.setText(model.ip);
        serverName.setText(model.remoteHostName);
        client.setText(model.clientIPAddr);
        counter.setText(model.success);
        fail.setText(String.valueOf(model.failure));
    }


}
