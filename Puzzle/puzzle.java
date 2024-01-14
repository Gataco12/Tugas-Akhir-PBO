import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class puzzle extends JFrame implements ActionListener {
 JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, next;
 Timer puzzleTimer; // Timer untuk lama pengerjaan puzzle
 int elapsedTimeInSeconds; // Waktu yang telah berlalu (dalam detik)
 JLabel timerLabel; // Label untuk menampilkan waktu

 public puzzle() {
  super("Puzzle Games");

  // Membuat JLabel untuk menampilkan gambar
  ImageIcon winImage = new ImageIcon("Judul_depan.png");

  // Membuat JWindow untuk menampilkan gambar transparan
  JWindow window = new JWindow();
  window.setBackground(new Color(0, 0, 0, 0)); // Menetapkan latar belakang menjadi transparan
  window.setLayout(new BorderLayout());
  window.setSize(winImage.getIconWidth(), winImage.getIconHeight());
  window.setLocationRelativeTo(null);

  // Menambahkan JLabel ke JWindow
  JLabel imageLabel = new JLabel(winImage);
  window.add(imageLabel, BorderLayout.CENTER);
  // Menampilkan JWindow
  window.setVisible(true);
  // Menambahkan timer untuk menutup otomatis jendela dialog setelah beberapa detik
  Timer timer = new Timer(3000, new ActionListener() {
   public void actionPerformed(ActionEvent arg0) {
    window.dispose(); // Menutup jendela dialog

    // Inisialisasi permainan langsung
    b1 = new JButton("1");
    b2 = new JButton(" ");
    b3 = new JButton("3");
    b4 = new JButton("4");
    b5 = new JButton("5");
    b6 = new JButton("6");
    b7 = new JButton("7");
    b8 = new JButton("8");
    b9 = new JButton("2");
    next = new JButton("Next");


    // Mengatur ukuran tombol (contoh: lebar = 150, tinggi = 40)
    Dimension buttonSize = new Dimension(250, 80);
    b1.setPreferredSize(buttonSize);
    b2.setPreferredSize(buttonSize);
    b3.setPreferredSize(buttonSize);
    b4.setPreferredSize(buttonSize);
    b5.setPreferredSize(buttonSize);
    b6.setPreferredSize(buttonSize);
    b7.setPreferredSize(buttonSize);
    b8.setPreferredSize(buttonSize);
    b9.setPreferredSize(buttonSize);
    next.setPreferredSize(buttonSize);

    setLayout(new GridLayout(4, 5, 5, 5)); // Mengganti layout manager ke GridLayout
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(b5);
    add(b6);
    add(b7);
    add(b8);
    add(b9);
    add(next);

    Font buttonFont = new Font("Arial", Font.BOLD, 18);
    next.setFont(buttonFont);

    b1.setBackground(Color.GRAY);
    b2.setBackground(Color.GRAY);
    b3.setBackground(Color.GRAY);
    b4.setBackground(Color.GRAY);
    b5.setBackground(Color.GRAY);
    b6.setBackground(Color.GRAY);
    b7.setBackground(Color.GRAY);
    b8.setBackground(Color.GRAY);
    b9.setBackground(Color.GRAY);

    b1.addActionListener(puzzle.this);
    b2.addActionListener(puzzle.this);
    b3.addActionListener(puzzle.this);
    b4.addActionListener(puzzle.this);
    b5.addActionListener(puzzle.this);
    b6.addActionListener(puzzle.this);
    b7.addActionListener(puzzle.this);
    b8.addActionListener(puzzle.this);
    b9.addActionListener(puzzle.this);
    next.addActionListener(puzzle.this);

    next.setBackground(Color.BLACK);
    next.setForeground(Color.GREEN);

    timerLabel = new JLabel("Waktu: 0 detik");
    timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
    add(timerLabel, BorderLayout.NORTH);

    // Mengatur warna label timer sama seperti tombol "next"
    timerLabel.setBackground(Color.BLACK);
    timerLabel.setForeground(Color.GREEN);
    timerLabel.setOpaque(true);

// Menetapkan ukuran dimensi label
    Dimension timerSize = new Dimension(100, 20); // Sesuaikan dengan kebutuhan
    timerLabel.setPreferredSize(timerSize);

    add(timerLabel, BorderLayout.NORTH);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    startPuzzleTimer();
   }
  });
  timer.setRepeats(false); // Set timer agar hanya berjalan satu kali
  timer.start();

  window.setVisible(true); // Menampilkan jendela dialog
 }//end of constuctor
 // Metode untuk memulai timer pengerjaan puzzle
 private void startPuzzleTimer() {
  elapsedTimeInSeconds = 0;
  puzzleTimer = new Timer(1000, new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent e) {
    elapsedTimeInSeconds++;
    updateTimerLabel();
   }
  });
  puzzleTimer.start();
 }

 // Metode untuk memperbarui label waktu
 private void updateTimerLabel() {
  timerLabel.setText("Waktu: " + elapsedTimeInSeconds + " detik");
 }// end construktor
 private void stopPuzzleTimer() {
  if (puzzleTimer != null && puzzleTimer.isRunning()) {
   puzzleTimer.stop();
  }
 }

 // ... (Kode ActionListener dan metode lainnya)

public void actionPerformed(ActionEvent e){
if(e.getSource()==next){
String s=b4.getLabel();
b4.setLabel(b9.getLabel());
b9.setLabel(s);
s=b1.getLabel();
b1.setLabel(b5.getLabel());
b5.setLabel(s);
s=b2.getLabel();
b2.setLabel(b7.getLabel());
b7.setLabel(s);
}
if(e.getSource()==b1){
String s=b1.getLabel();
if(b2.getLabel().equals(" ")){ b2.setLabel(s); b1.setLabel(" ");}
else if(b4.getLabel().equals(" ")){ b4.setLabel(s); b1.setLabel(" ");}
 }//end of if

if(e.getSource()==b3){
String s=b3.getLabel();
if(b2.getLabel().equals(" ")){ b2.setLabel(s); b3.setLabel(" ");}
else if(b6.getLabel().equals(" ")){ b6.setLabel(s); b3.setLabel(" ");}
 }//end of if

if(e.getSource()==b2){
String s=b2.getLabel();
if(b1.getLabel().equals(" ")){ b1.setLabel(s); b2.setLabel(" ");}
else if(b3.getLabel().equals(" ")){ b3.setLabel(s); b2.setLabel(" ");}
else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b2.setLabel(" ");}
 }//end of if

if(e.getSource()==b4){
String s=b4.getLabel();
if(b1.getLabel().equals(" ")){ b1.setLabel(s); b4.setLabel(" ");}
else if(b7.getLabel().equals(" ")){ b7.setLabel(s); b4.setLabel(" ");}
else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b4.setLabel(" ");}
 }//end of if

if(e.getSource()==b5){
String s=b5.getLabel();
if(b2.getLabel().equals(" ")){ b2.setLabel(s); b5.setLabel(" ");}
else if(b4.getLabel().equals(" ")){ b4.setLabel(s); b5.setLabel(" ");}
else if(b6.getLabel().equals(" ")){ b6.setLabel(s); b5.setLabel(" ");}
else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b5.setLabel(" ");}
 }
if(e.getSource()==b6){

String s=b6.getLabel();
if(b9.getLabel().equals(" ")){ b9.setLabel(s); b6.setLabel(" ");}
else if(b3.getLabel().equals(" ")){ b3.setLabel(s); b6.setLabel(" ");}
else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b6.setLabel(" ");}

 }
if(e.getSource()==b7){
String s=b7.getLabel();
if(b4.getLabel().equals(" ")){ b4.setLabel(s); b7.setLabel(" ");}
else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b7.setLabel(" ");}

 }
if(e.getSource()==b8){
String s=b8.getLabel();
if(b7.getLabel().equals(" ")){ b7.setLabel(s); b8.setLabel(" ");}
else if(b9.getLabel().equals(" ")){ b9.setLabel(s); b8.setLabel(" ");}
else if(b5.getLabel().equals(" ")){ b5.setLabel(s); b8.setLabel(" ");}

 }
if(e.getSource()==b9){
String s=b9.getLabel();
if(b6.getLabel().equals(" ")){ b6.setLabel(s); b9.setLabel(" ");}
else if(b8.getLabel().equals(" ")){ b8.setLabel(s); b9.setLabel(" ");}
 if (b1.getLabel().equals("1") && b2.getLabel().equals("2") && b3.getLabel().equals("3") && b4.getLabel().equals("4") &&
         b5.getLabel().equals("5") && b6.getLabel().equals("6") && b7.getLabel().equals("7") && b8.getLabel().equals("8") &&
         b9.getLabel().equals(" ")) {
  stopPuzzleTimer(); // Menhentikan timer ketika pemain menang

  // Membuat JDialog untuk menampilkan gambar kemenangan
  JDialog winDialog = new JDialog(this, "Congratulations", true);
  winDialog.setLayout(new BorderLayout());

  // Membuat JLabel untuk menampilkan gambar kemenangan
  ImageIcon winImage = new ImageIcon("younwin.png");
  JLabel winImageLabel = new JLabel(winImage);

  // Membuat JWindow untuk menampilkan gambar transparan
  JWindow window = new JWindow();
  window.setBackground(new Color(0, 0, 0, 0)); // Menetapkan latar belakang menjadi transparan
  window.setLayout(new BorderLayout());
  window.setSize(winImage.getIconWidth(), winImage.getIconHeight());
  window.setLocationRelativeTo(null);

  // Menambahkan JLabel ke JWindow
  JLabel imageLabel = new JLabel(winImage);
  window.add(imageLabel, BorderLayout.CENTER);

  // Menampilkan JWindow
  window.setVisible(true);

 }
 }
}
public static void main(String[] args){
new puzzle();
}//end of main

}//end of class