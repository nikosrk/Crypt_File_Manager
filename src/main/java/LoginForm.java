
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;


/**
 *
 * @author nikos
 */
class LoginForm extends javax.swing.JFrame {

    //Login form constructor
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextUsername = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jLabelRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(36, 37, 42));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Login Form");

        jLabelMin.setFont(new java.awt.Font("Ubuntu", 1, 28)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(242, 241, 240));
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });

        jLabelClose.setFont(new java.awt.Font("Ubuntu", 1, 22)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(242, 241, 240));
        jLabelClose.setText("x");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelClose, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelMin)
                    .addComponent(jLabelClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 110, 123));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Password:");

        jPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldActionPerformed(evt);
            }
        });

        jButtonLogin.setBackground(java.awt.Color.white);
        jButtonLogin.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonLogin.setForeground(java.awt.Color.black);
        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButtonLoginActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        jLabelRegister.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabelRegister.setText("Click here to create a new account");
        jLabelRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegisterMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonLogin))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextUsername)
                            .addComponent(jPasswordField)))
                    .addComponent(jLabelRegister, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButtonLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelRegister)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }
    //redirect to register form if the button is clicked
    private void jLabelRegisterMouseClicked(java.awt.event.MouseEvent evt) {
        //initialize register form
        RegisterForm rgf = new RegisterForm();
        rgf.setVisible(true);
        rgf.pack();
        rgf.setLocationRelativeTo(null);
        rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }

    private void jButtonLoginActionPerformed(ActionEvent evt) throws Exception {
        String usernameText = jTextUsername.getText();
        String passText = new String(jPasswordField.getPassword());
        boolean check = false;
        try {
            //check if username entered exists on the users file
            BufferedReader reader = new BufferedReader(new FileReader(new File("appFiles/users.txt")));
            for(String line;(line = reader.readLine()) != null;) {
                int i = line.indexOf('-');
                String testString = line.substring(0, i);
                if (testString.equals(usernameText)) {
                    check = true;
                }
                //if username exists check if the password entered correctly
                if (check) {
                    i = line.indexOf("---");
                    int j = line.indexOf("----");
                    String salt = line.substring(i+3,j);
                    Authentication go = new Authentication();
                    String hashedPassword = go.getSecurePassword(passText,salt);
                    i = line.indexOf("----");
                    String pass = line.substring(i+4);
                    AsymmetricCryptography ac = new AsymmetricCryptography();
                    PrivateKey privatekey = ac.getPrivate("appFiles/KeyPair/privateKey");
                    pass = ac.decryptText(pass, privatekey);
                    //if password wrong change check variable's value
                    if(!(pass.equals(hashedPassword))){
                        check = false;
                    }
                }

            }

        }catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //if user enters the info correctly
        if(check){
            //integrity check
            File file = new File("appFiles/" + usernameText + "/encryptedSignature.txt");
            if(file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                IntegrityCheck ic = new IntegrityCheck();
                String checker = ic.signature("appFiles/" + usernameText + "/");
                //message for integrity violation
                if (!(line.equals(checker))) {
                    JOptionPane.showMessageDialog(new JFrame(), "Your integrity Has been violated");
                }
            }
            //initialize main form
            MainForm mf = new MainForm(usernameText);
            mf.setVisible(true);
            mf.pack();
            mf.setLocationRelativeTo(null);
            mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.dispose();
        }
        //print message for wrong inputs(username or password)
        else{
            JOptionPane.showMessageDialog(new JFrame(), "Wrong Username or Password");
        }
    }
    //minimize window
    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {
        this.setState(JFrame.ICONIFIED);
    }
    //close window
    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {
        System.exit(0);
    }

    //Variables declaration
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JLabel jLabelRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextUsername;
    // End of variables declaration
}
