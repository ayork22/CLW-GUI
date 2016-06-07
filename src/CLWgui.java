import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class CLWgui
{

    protected Shell shell;
    private Text emHost;
    private CLabel label;
    private Text emPort;
    private CLabel label_1;
    private Text emUser;
    private CLabel label_2;
    private Text emPass;
    private CLabel label_3;
    private Text clwJAR;
    private CLabel label_4;
    private Text clwCommand;
    private CLabel label_5;
    private Text java;
    private CLabel label_6;
    private Text agent;

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            CLWgui window = new CLWgui();
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
        shell.setSize(450, 370);
        shell.setText("CLW GUI");
        
        CLabel lblEmHost = new CLabel(shell, SWT.NONE);
        lblEmHost.setBounds(29, 46, 61, 19);
        lblEmHost.setText("EM Host:");
        
        emHost = new Text(shell, SWT.BORDER);
        emHost.setBounds(105, 46, 85, 19);
        
        Button btnRunClw = new Button(shell, SWT.NONE);
        btnRunClw.setBounds(175, 282, 94, 28);
        btnRunClw.setText("Run CLW");
        
        label = new CLabel(shell, SWT.NONE);
        label.setText("EM Port:");
        label.setBounds(29, 71, 61, 19);
        
        emPort = new Text(shell, SWT.BORDER);
        emPort.setBounds(105, 71, 85, 19);
        
        label_1 = new CLabel(shell, SWT.NONE);
        label_1.setText("EM Username:");
        label_1.setBounds(29, 96, 61, 19);
        
        emUser = new Text(shell, SWT.BORDER);
        emUser.setBounds(105, 96, 85, 19);
        
        label_2 = new CLabel(shell, SWT.NONE);
        label_2.setText("EM Password:");
        label_2.setBounds(29, 121, 61, 19);
        
        emPass = new Text(shell, SWT.BORDER);
        emPass.setBounds(105, 121, 85, 19);
        
        label_3 = new CLabel(shell, SWT.NONE);
        label_3.setText("CLW JAR Location:");
        label_3.setBounds(29, 146, 61, 19);
        
        clwJAR = new Text(shell, SWT.BORDER);
        clwJAR.setBounds(105, 146, 85, 19);
        
        label_4 = new CLabel(shell, SWT.NONE);
        label_4.setText("CLW Command:");
        label_4.setBounds(29, 171, 61, 19);
        
        clwCommand = new Text(shell, SWT.BORDER);
        clwCommand.setBounds(105, 171, 85, 19);
        
        label_5 = new CLabel(shell, SWT.NONE);
        label_5.setText("Java:");
        label_5.setBounds(29, 196, 61, 19);
        
        java = new Text(shell, SWT.BORDER);
        java.setBounds(105, 196, 85, 19);
        
        label_6 = new CLabel(shell, SWT.NONE);
        label_6.setText("Agent:");
        label_6.setBounds(29, 222, 61, 19);
        
        agent = new Text(shell, SWT.BORDER);
        agent.setBounds(105, 222, 85, 19);
        
        btnRunClw.addListener(SWT.Selection, new Listener( ) {
            @Override
            public void handleEvent(Event event)
            {
                System.out.println(emHost.getText());
                
            }
        });
        

    }
}
