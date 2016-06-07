import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class CLW
{

    protected Shell shell;
    private Text emHost;
    private Text emPort;
    private Text emUser;
    private Text emPass;
    private Label lblClwCommand;
    private Text clwCommand;
    private Label lblClwJar;
    private Label lblJava;
    private Text clwJAR;
    private Text java;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            CLW window = new CLW();
            window.open();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open()
    {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed())
        {
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents()
    {
        shell = new Shell();
        shell.setSize(450, 300);
        shell.setText("CLW GUI");
        
        Button btnRunClw = new Button(shell, SWT.NONE);
        btnRunClw.setBounds(172, 240, 94, 28);
        btnRunClw.setText("Run CLW");
        
        Label lblEmPort = new Label(shell, SWT.NONE);
        lblEmPort.setBounds(24, 75, 77, 14);
        lblEmPort.setText("EM Port:");
        
        Label lblEmHost = new Label(shell, SWT.NONE);
        lblEmHost.setBounds(24, 57, 77, 14);
        lblEmHost.setText("EM Host:");
        
        Label lblEmUsername = new Label(shell, SWT.NONE);
        lblEmUsername.setBounds(24, 95, 94, 14);
        lblEmUsername.setText("EM Username:");
        
        emHost = new Text(shell, SWT.BORDER);
        emHost.setBounds(146, 57, 64, 14);
        
        emPort = new Text(shell, SWT.BORDER);
        emPort.setBounds(146, 75, 64, 14);
        
        emUser = new Text(shell, SWT.BORDER);
        emUser.setBounds(146, 95, 64, 14);
        
        emPass = new Text(shell, SWT.BORDER);
        emPass.setBounds(146, 115, 64, 14);
        
        Label lblEmPassword = new Label(shell, SWT.NONE);
        lblEmPassword.setBounds(24, 115, 77, 14);
        lblEmPassword.setText("EM Password:");
        
        lblClwCommand = new Label(shell, SWT.NONE);
        lblClwCommand.setBounds(24, 135, 94, 14);
        lblClwCommand.setText("CLW Command:");
        
        clwCommand = new Text(shell, SWT.BORDER);
        clwCommand.setBounds(146, 135, 64, 14);
        
        lblClwJar = new Label(shell, SWT.NONE);
        lblClwJar.setBounds(24, 155, 59, 14);
        lblClwJar.setText("CLW JAR:");
        
        lblJava = new Label(shell, SWT.NONE);
        lblJava.setBounds(24, 175, 59, 14);
        lblJava.setText("Java:");
        
        clwJAR = new Text(shell, SWT.BORDER);
        clwJAR.setBounds(146, 155, 64, 14);
        
        java = new Text(shell, SWT.BORDER);
        java.setBounds(146, 175, 64, 14);
        
        btnRunClw.addListener(SWT.Selection, new Listener( ) {
            private String line;

            @Override
            public void handleEvent(Event event)
            {
                System.out.println(emHost.getText());
                try
                {
                    Process p = Runtime.getRuntime().exec(
                                                          java.getText() + " -Duser=" + emUser.getText() + " -Dpassword=" + emPass.getText() + " -Dhost=" + emHost.getText() + " -Dport=" + emPort.getText() + " -jar " + clwJAR.getText() + " " + clwCommand.getText());
                
                System.out.println("Command = " + java.getText() + " -Duser=" + emUser.getText() + " -Dpassword=" + emPass.getText() + " -Dhost=" + emHost.getText() + " -Dport=" + emPort.getText() + " -jar " + clwJAR.getText() + " " + clwCommand.getText());
                    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    while ((line = input.readLine()) != null) {

                        // Used for writing to File
                        // bw.append(line);
                        // bw.newLine();
                        // bw.append("test");

                        // Build String in WHILE loop
                        
                        sb.append(line);
                        // Adds line if desired
                        sb.append(System.getProperty("line.separator"));

                    }
                    // Print FINAL String of all Agents
                    String result = sb.toString();
                    System.out.println("Agent List" + "\n" + result);
                    // Close connections
                    // bw.close();
                    input.close();
                } catch (IOException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
            
            
        });

    }
}
