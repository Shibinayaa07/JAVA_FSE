package deepskilling.week_1.design_patterns;

public class Exercise06Proxy {
    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private final String fileName;

        RealImage(String fileName) {
            this.fileName = fileName;
            loadFromRemoteServer();
        }

        private void loadFromRemoteServer() {
            System.out.println("Loading " + fileName + " from remote server");
        }

        public void display() {
            System.out.println("Displaying " + fileName);
        }
    }

    static class ProxyImage implements Image {
        private final String fileName;
        private RealImage realImage;

        ProxyImage(String fileName) {
            this.fileName = fileName;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(fileName);
            }
            realImage.display();
        }
    }

    public static void main(String[] args) {
        Image image = new ProxyImage("profile.png");
        image.display();
        image.display();
    }
}
