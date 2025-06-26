import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Book[] books = new Book[10];
    static int bookCount = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("\n---Kütüphane Otomasyon Sistemi---");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Kitapları Listele");
            System.out.println("3. Yazara Göre Kitapları Listele");
            System.out.println("4. Toplam Kitap Sayısı");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminiz: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                //kitap ekleme
                case 1:
                    System.out.print("Kitap Adı: ");
                    String title = scanner.nextLine();
                    System.out.print("Yazar: ");
                    String author = scanner.nextLine();
                    System.out.print("Sayfa Sayısı: ");
                    int pageCount = scanner.nextInt();
                    scanner.nextLine();

                    books[bookCount] = new Book(title, author, pageCount);
                    bookCount++;
                    System.out.println("Kitap başarıyla eklendi!");
                    break;
                //listeleme
                case 2:
                    if (bookCount == 0) {
                        System.out.println("Henüz kitap eklenmemiş.");
                    } else {
                        System.out.println("---Kitap Listesi---");
                        for (int i = 0; i < bookCount; i++) {
                            Book book = books[i];
                            System.out.println((i + 1) + ". Kitap Adı: " + book.getTitle() +
                                    ", Yazar: " + book.getAuthor() +
                                    ", Sayfa: " + book.getPageCount());
                        }
                    }
                    break;
                //yazara göre listele
                case 3:
                    System.out.print("Yazar Adı: ");
                    String searchAuthor = scanner.nextLine();
                    boolean found = false;
                    System.out.println("---" + searchAuthor + "'ya Ait Kitaplar---");
                    for (int i = 0; i < bookCount; i++) {
                        Book book = books[i];
                        if (book.getAuthor().equalsIgnoreCase(searchAuthor)) {
                            System.out.println("Kitap Adı: " + book.getTitle() +
                                    ", Sayfa: " + book.getPageCount());
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Bu yazara ait kitap bulunamadı.");
                    }
                    break;
                //toplam kitap sayısı
                case 4:
                    System.out.println("Toplam Kitap Sayısı: " + bookCount);
                    break;
                //çıkış
                case 5:
                    System.out.println("Programdan çıkılıyor...");
                    return;
                //yanlış seçim
                default:
                    System.out.println("Geçersiz seçim, tekrar deneyin.");
            }
        }
    }
}