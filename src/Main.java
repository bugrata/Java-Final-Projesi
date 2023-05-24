import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame{
     public static int tasiSecim = 0;
     public static int gizSecim = 0;
     public static int sifreSecim = 0;

    public static void main(String[] args) {

         //Pencere kodları
         JFrame frame = new JFrame();
         frame.setTitle("IMU Final Project");
         frame.setLayout(new BorderLayout(10,10));
         frame.setSize(600, 300);
         frame.setResizable(false);
         frame.setBackground(Color.LIGHT_GRAY);
         frame.setLocationRelativeTo(null);
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         //Panel nesnelerinin oluşturulması
         JPanel panel1 = new JPanel();
         JPanel panel2 = new JPanel();
         JPanel panel3 = new JPanel();
         JPanel panel4 = new JPanel();
         JPanel panel5 = new JPanel();

         //Panel 1 in kodları
         panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
         panel1.setBackground(Color.CYAN);
         JLabel label1 = new JLabel("Dosya Sifreleme ve Tasima Uygulamasi");
         panel1.add(label1);

         //Panel 2 nin kodları
         BoxLayout blay1 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
         panel2.setLayout(blay1);
         panel2.setBorder(new EmptyBorder(new Insets(35, 15, 0, 15)));
         panel2.setBackground(Color.LIGHT_GRAY);
         JCheckBox cbox1 = new JCheckBox("Tum Dosyalar");
         JCheckBox cbox2 = new JCheckBox("PDF Dosyaları");
         JCheckBox cbox3 = new JCheckBox("DOC Dosyaları");
         JCheckBox cbox4 = new JCheckBox("TXT Dosyaları");
         cbox1.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("Tum Dosyalar secimi kaldirildi");
                        cbox1.setText("Tum Dosyalar");
                   }
                   else {
                        System.out.println("Tum Dosyalar secildi");
                        cbox1.setText("*Tum Dosyalar*");
                        tasiSecim = 1;
                   }
              }
         });
         cbox2.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("PDF Dosyaları secimi kaldirildi");
                        cbox2.setText("PDF Dosyaları");
                   }
                   else {
                        System.out.println("PDF Dosyaları secildi");
                        cbox2.setText("*PDF Dosyaları*");
                        tasiSecim = 2;
                   }
              }
         });
         cbox3.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("DOC Dosyaları secimi kaldirildi");
                        cbox3.setText("DOC Dosyaları");
                   }
                   else {
                        System.out.println("DOC Dosyaları secildi");
                        cbox3.setText("*DOC Dosyaları*");
                        tasiSecim = 3;
                   }
              }
         });
         cbox4.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("TXT Dosyaları secimi kaldirildi");
                        cbox4.setText("TXT Dosyaları");
                   }
                   else {
                        System.out.println("TXT Dosyaları secildi");
                        cbox4.setText("*TXT Dosyaları*");
                        tasiSecim = 4;
                   }
              }
         });

         panel2.add(cbox1);
         panel2.add(cbox2);
         panel2.add(cbox3);
         panel2.add(cbox4);

         //Panel 3 ün kodları
         BoxLayout blay2 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
         panel3.setLayout(blay2);
         panel3.setBorder(new EmptyBorder(new Insets(60, 15, 0, 15)));
         panel3.setBackground(Color.LIGHT_GRAY);
         JCheckBox cbox5 = new JCheckBox("Dosyalari Sifrele");
         JCheckBox cbox6 = new JCheckBox("Dosyalari Gizle");
         cbox5.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("Dosyalari Sifrele secimi kaldirildi");
                        cbox5.setText("Dosyalari Sifrele");
                   }
                   else {
                        System.out.println("Dosyalari Sifrele secildi");
                        cbox5.setText("*Dosyalari Sifrele*");
                        sifreSecim = 1;
                   }
              }
         });
         cbox6.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("Dosyalari Gizle secimi kaldirildi");
                        cbox6.setText("Dosyalari Gizle");
                   }
                   else {
                        System.out.println("Dosyalari Gizle secildi");
                        cbox6.setText("*Dosyalari Gizle*");
                        gizSecim = 1;
                   }
              }
         });

         panel3.add(cbox5);
         panel3.add(cbox6);

         //Panel 5 in kodları
         panel5.setBackground(Color.LIGHT_GRAY);
         JLabel label4 = new JLabel("Mevcut ve İletilecek Konumu Giriniz");
         JLabel label2 = new JLabel("Dosyanın konumu: ");
         JTextField tfield1 = new JTextField(10);
         JLabel label3 = new JLabel("Taşınacak konum: ");
         JTextField tfield2 = new JTextField(10);

         panel5.add(label4);
         panel5.add(label2);
         panel5.add(tfield1);
         panel5.add(label3);
         panel5.add(tfield2);

         //Panel 4 ün kodları
         panel4.setBackground(Color.LIGHT_GRAY);
         JButton button3 = new JButton("Dosyalari Tasi");
         panel4.add(button3);
         button3.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   System.out.println("Dosyalari Tasi butonu tiklandi");
                   String ilkKonum = tfield1.getText();
                   String sonKonum = tfield2.getText();
                   int tasimaSecim = tasiSecim;
                   int sifreleSecim = sifreSecim;
                   int gizleSecim = gizSecim;
                   Move dosyaTasi = new Move(ilkKonum, sonKonum);
                   Hide dosyaGizle = new Hide(ilkKonum);
                   EncryptPdf pdfSifrele = new EncryptPdf(ilkKonum);
                   EncryptDocx docSifrele = new EncryptDocx(ilkKonum);
                   EncryptTxt txtSifrele = new EncryptTxt(ilkKonum);


                   if (sifreleSecim == 1 && tasimaSecim == 1) {
                        pdfSifrele.encryptPdf();
                        docSifrele.encryptDocx();
                        txtSifrele.encryptTxt();
                   }
                   else if (sifreleSecim == 1 && tasimaSecim == 2) {
                        pdfSifrele.encryptPdf();
                   }
                   else if (sifreleSecim == 1 && tasimaSecim == 3) {
                        docSifrele.encryptDocx();
                   }
                   else if (sifreleSecim == 1 && tasimaSecim == 4) {
                        txtSifrele.encryptTxt();
                   }


                   if (gizleSecim == 1 && tasimaSecim == 1) {
                        try {
                             dosyaGizle.hideAll();
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        }
                   }
                   else if (gizleSecim == 1 && tasimaSecim == 2) {
                        try {
                             dosyaGizle.hidePdf();
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        }
                   }
                   else if (gizleSecim == 1 && tasimaSecim == 3) {
                        try {
                             dosyaGizle.hideDocx();
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        }
                   }
                   else if (gizleSecim == 1 && tasimaSecim == 4) {
                        try {
                             dosyaGizle.hideTxt();
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        }
                   }


                   if (tasimaSecim == 1) {
                        try {
                             dosyaTasi.moveAll();
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        }
                   }
                   else if (tasimaSecim == 2) {
                        try {
                             dosyaTasi.movePdf();
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        }
                   }
                   else if (tasimaSecim == 3) {
                        try {
                             dosyaTasi.moveDocx();
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        }
                   }
                   else if (tasimaSecim == 4) {
                        try {
                             dosyaTasi.moveTxt();
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        }
                   }
                   else {
                        System.out.println("Lutfen gecerli bir islem seciniz!");
                   }
              }
         });

         //Panellerin pencereye eklenmesi
         frame.add(panel1, BorderLayout.NORTH);
         frame.add(panel2, BorderLayout.EAST);
         frame.add(panel3, BorderLayout.WEST);
         frame.add(panel4, BorderLayout.SOUTH);
         frame.add(panel5, BorderLayout.CENTER);

         frame.setVisible(true);

    }
}