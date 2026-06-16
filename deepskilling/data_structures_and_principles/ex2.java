/*
Exercise 2: Implementing the Factory Method Pattern
Scenario: 
You are developing a document management system that needs to create different types of documents (e.g., Word, PDF, Excel). Use the Factory Method Pattern to achieve this.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named FactoryMethodPatternExample.
2.	Define Document Classes:
o	Create interfaces or abstract classes for different document types such as WordDocument, PdfDocument, and ExcelDocument.
3.	Create Concrete Document Classes:
o	Implement concrete classes for each document type that implements or extends the above interfaces or abstract classes.
4.	Implement the Factory Method:
o	Create an abstract class DocumentFactory with a method createDocument().
o	Create concrete factory classes for each document type that extends DocumentFactory and implements the createDocument() method.
5.	Test the Factory Method Implementation:
o	Create a test class to demonstrate the creation of different document types using the factory method.

 */
package deepskilling.data_structures_and_principles;

interface Doc{
    void createD();
}
public class ex2 {
    // Concrete document implementations
    static class WordDocument implements Doc{
        public void createD(){ System.out.println("Creating Word document..."); }
    }

    static class PdfDocument implements Doc{
        public void createD(){ System.out.println("Creating PDF document..."); }
    }

    static class ExcelDocument implements Doc{
        public void createD(){ System.out.println("Creating Excel document..."); }
    }

    // Factory method base
    static abstract class DocumentFactory{
        abstract Doc createDocument();
    }

    // Concrete factories
    static class WordFactory extends DocumentFactory{
        Doc createDocument(){ return new WordDocument(); }
    }

    static class PdfFactory extends DocumentFactory{
        Doc createDocument(){ return new PdfDocument(); }
    }

    static class ExcelFactory extends DocumentFactory{
        Doc createDocument(){ return new ExcelDocument(); }
    }

    public static void main(String[] args) {
        DocumentFactory f1 = new WordFactory();
        Doc d1 = f1.createDocument();
        d1.createD();

        DocumentFactory f2 = new PdfFactory();
        Doc d2 = f2.createDocument();
        d2.createD();

        DocumentFactory f3 = new ExcelFactory();
        Doc d3 = f3.createDocument();
        d3.createD();
    }

}
