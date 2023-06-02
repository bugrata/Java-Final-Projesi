//Gerekli kütüphaneleri import ettik
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.swing.filechooser.*;

public class Main extends JFrame{
     public static int tasiSecim = 0;
     public static int gizSecim = 0;
     public static int sifreSecim = 0;
     public static int desifreSecim = 0;
     public static String ilkKonum;
     public static String sonKonum;


    public static void main(String[] args) {

         //Pencere kodları
         JFrame frame = new JFrame();
         frame.setTitle("İMÜ FİNAL PROJESİ");
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
         JLabel label1 = new JLabel("Dosya Şifreleme ve Taşıma Uygulaması");
         panel1.add(label1);

         //Panel 2 nin kodları
         BoxLayout blay1 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
         panel2.setLayout(blay1);
         panel2.setBorder(new EmptyBorder(new Insets(35, 15, 0, 15)));
         panel2.setBackground(Color.LIGHT_GRAY);
         JCheckBox cbox1 = new JCheckBox("Tüm Dosyalar");
         JCheckBox cbox2 = new JCheckBox("PDF Dosyaları");
         JCheckBox cbox3 = new JCheckBox("DOC Dosyaları");
         JCheckBox cbox4 = new JCheckBox("TXT Dosyaları");
         //Eklediğimiz checkboxlarda yapılan işlemlerin kaydetmesi için eklenmiş actionlistener fonksiyonu
         cbox1.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("Tüm Dosyalar seçimi kaldırıldı");
                        cbox1.setText("Tüm Dosyalar");
                   }
                   else {
                        System.out.println("Tüm Dosyalar seçildi");
                        cbox1.setText("*Tüm Dosyalar*");
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
                        System.out.println("PDF Dosyaları seçimi kaldırıldı");
                        cbox2.setText("PDF Dosyaları");
                   }
                   else {
                        System.out.println("PDF Dosyaları seçildi");
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
                        System.out.println("DOC Dosyaları seçimi kaldırıldı");
                        cbox3.setText("DOC Dosyaları");
                   }
                   else {
                        System.out.println("DOC Dosyaları seçildi");
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
                        System.out.println("TXT Dosyaları seçimi kaldırıldı");
                        cbox4.setText("TXT Dosyaları");
                   }
                   else {
                        System.out.println("TXT Dosyaları seçildi");
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
         panel3.setBorder(new EmptyBorder(new Insets(50, 15, 0, 15)));
         panel3.setBackground(Color.LIGHT_GRAY);
         JCheckBox cbox5 = new JCheckBox("Dosyaları Şifrele");
         JCheckBox cbox6 = new JCheckBox("Dosyaları Gizle");
         JCheckBox cbox7 = new JCheckBox("Şifreyi Çöz");
         //Eklediğimiz checkboxlarda yapılan işlemlerin kaydetmesi için eklenmiş actionlistener fonksiyonu
         cbox5.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("Dosyaları Şifrele seçimi kaldırıldı");
                        cbox5.setText("Dosyaları Şifrele");
                   }
                   else {
                        System.out.println("Dosyalari Şifrele seçildi");
                        cbox5.setText("*Dosyaları Şifrele*");
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
                        System.out.println("Dosyalari Gizle seçimi kaldırıldı");
                        cbox6.setText("Dosyaları Gizle");
                   }
                   else {
                        System.out.println("Dosyalari Gizle secildi");
                        cbox6.setText("*Dosyaları Gizle*");
                        gizSecim = 1;
                   }
              }
         });

         cbox7.addActionListener(new ActionListener() {
              int sayac = 0;
              @Override
              public void actionPerformed(ActionEvent e) {
                   sayac++;
                   if (sayac % 2 == 0) {
                        System.out.println("Şifreyi Çöz seçimi kaldırıldı");
                        cbox7.setText("Şifreyi Çöz");
                   }
                   else {
                        System.out.println("Şifreyi Çöz secildi");
                        cbox7.setText("*Şifreyi Çöz*");
                        desifreSecim = 1;
                   }
              }
         });

         panel3.add(cbox5);
         panel3.add(cbox6);
         panel3.add(cbox7);

         //Panel 5 in kodları
         panel5.setBackground(Color.LIGHT_GRAY);
         JLabel label4 = new JLabel("Mevcut ve İletilecek Konumu Giriniz");
         JLabel label2 = new JLabel("Dosyanın konumu: ");
         JButton button2 = new JButton("Seçiniz");
         JLabel label3 = new JLabel("Taşınacak konum: ");
         JButton button3 = new JButton("Seçiniz");

         panel5.add(label4);
         panel5.add(label2);
         panel5.add(button2);
         panel5.add(label3);
         panel5.add(button3);

         button2.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   JFileChooser fileChooser1 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                   fileChooser1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                   int r = fileChooser1.showOpenDialog(null);
                   if (r == JFileChooser.APPROVE_OPTION) {
                        ilkKonum = fileChooser1.getSelectedFile().getAbsolutePath();
                        ilkKonum = ilkKonum + "\\";
                        System.out.println(ilkKonum);
                   }
              }
         });

         button3.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   JFileChooser fileChooser2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                   fileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                   int r = fileChooser2.showSaveDialog(null);
                   if (r == JFileChooser.APPROVE_OPTION) {
                        sonKonum = fileChooser2.getSelectedFile().getAbsolutePath();
                        sonKonum = sonKonum + "\\";
                        System.out.println(sonKonum);
                   }
              }
         });

         //Panel 4 ün kodları
         panel4.setBackground(Color.LIGHT_GRAY);
         JButton button1 = new JButton("Dosyaları Taşı");
         panel4.add(button1);
         //Gerekli işlemler yapıldıktan sonra en son taşı butonuna basıldığında gerçekleşen işlemlerin olduğu actionlistener fonksiyonu
         button1.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                   System.out.println("Dosyaları Taşı butonu tıklandı");
                   int tasimaSecim = tasiSecim;
                   int sifreleSecim = sifreSecim;
                   int gizleSecim = gizSecim;
                   int desifreleSecim = desifreSecim;
                   Move dosyaTasi = new Move(ilkKonum, sonKonum);
                   Hide dosyaGizle = new Hide(ilkKonum);
                   EncryptPdf pdfSifrele = new EncryptPdf(ilkKonum);
                   EncryptDocx docSifrele = new EncryptDocx(ilkKonum);
                   EncryptTxt txtSifrele = new EncryptTxt(ilkKonum);
                   Decryption txtDesifrele = new Decryption(ilkKonum);

                   //Yapılan seçimlerle taşıancak dosyaların şifreleme işlemlerini yapan algoritma
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

                   //Yapılan seçimlerle taşıancak dosyaların deşifreleme işlemlerini yapan algoritma
                   if (desifreleSecim == 1 && tasimaSecim == 1) {
                        try {
                             txtDesifrele.decryptor();
                        } catch (NoSuchAlgorithmException ex) {
                             throw new RuntimeException(ex);
                        } catch (NoSuchPaddingException ex) {
                             throw new RuntimeException(ex);
                        } catch (InvalidKeyException ex) {
                             throw new RuntimeException(ex);
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        } catch (IllegalBlockSizeException ex) {
                             throw new RuntimeException(ex);
                        } catch (BadPaddingException ex) {
                             throw new RuntimeException(ex);
                        }
                        ;
                   }
                   else if (desifreleSecim == 1 && tasimaSecim == 2) {
                        try {
                             txtDesifrele.decryptor();
                        } catch (NoSuchAlgorithmException ex) {
                             throw new RuntimeException(ex);
                        } catch (NoSuchPaddingException ex) {
                             throw new RuntimeException(ex);
                        } catch (InvalidKeyException ex) {
                             throw new RuntimeException(ex);
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        } catch (IllegalBlockSizeException ex) {
                             throw new RuntimeException(ex);
                        } catch (BadPaddingException ex) {
                             throw new RuntimeException(ex);
                        }
                        ;
                   }
                   else if (desifreleSecim == 1 && tasimaSecim == 3) {
                        try {
                             txtDesifrele.decryptor();
                        } catch (NoSuchAlgorithmException ex) {
                             throw new RuntimeException(ex);
                        } catch (NoSuchPaddingException ex) {
                             throw new RuntimeException(ex);
                        } catch (InvalidKeyException ex) {
                             throw new RuntimeException(ex);
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        } catch (IllegalBlockSizeException ex) {
                             throw new RuntimeException(ex);
                        } catch (BadPaddingException ex) {
                             throw new RuntimeException(ex);
                        }
                        ;
                   }
                   else if (desifreleSecim == 1 && tasimaSecim == 4) {
                        try {
                             txtDesifrele.decryptor();
                        } catch (NoSuchAlgorithmException ex) {
                             throw new RuntimeException(ex);
                        } catch (NoSuchPaddingException ex) {
                             throw new RuntimeException(ex);
                        } catch (InvalidKeyException ex) {
                             throw new RuntimeException(ex);
                        } catch (IOException ex) {
                             throw new RuntimeException(ex);
                        } catch (IllegalBlockSizeException ex) {
                             throw new RuntimeException(ex);
                        } catch (BadPaddingException ex) {
                             throw new RuntimeException(ex);
                        }
                        ;
                   }

                   //Yapılan seçimlerle taşıancak dosyaların gizleme işlemlerini yapan algoritma
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

                   //Yapılan seçimlerle hangi dosya türlerinin taşınacağına göre işlem yapan algoritma
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
                        System.out.println("Lutfen geçerli bir işlem seçiniz!");
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