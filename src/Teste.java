import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Teste extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);
        scene.setFill(Color.BLACK);
        primaryStage.setScene(scene);

        // Cria o retângulo
        Rectangle r1 = new Rectangle();
        r1.setX(0);
        r1.setY(0);
        r1.setHeight(100);
        r1.setWidth(100);
        // Não definimos uma cor de preenchimento porque vamos sobrepor com a imagem
        // r1.setFill(Color.BLUE);
        root.getChildren().add(r1);

        // Carrega a imagem
        Image image = new Image("file:/C:/Users/camar/OneDrive/Desktop/Ratão.jpg"); // Certifique-se de que o caminho está correto
        ImageView imageView = new ImageView(image);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);

        Image image2 = new Image("file:");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setX(0);
        imageView2.setY(0);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);

        // Adiciona a imagem ao grupo root
        root.getChildren().add(imageView);

        final long startNanoTime = System.nanoTime();

        new AnimationTimer() {
            double speedX = 1;
            double speedY = 1;

            @Override
            public void handle(long currentNanoTime) {
                double timer = (currentNanoTime - startNanoTime) / 10000000000.0;
                if (r1.getX() > scene.getWidth() - r1.getWidth() || r1.getX() < 0)
                    speedX *= -1;
                r1.setX(r1.getX() + speedX);
                imageView.setX(r1.getX());

                if (r1.getY() > scene.getHeight() - r1.getHeight() || r1.getY() < 0)
                    speedY *= -1;
                r1.setY(r1.getY() + speedY);
                imageView.setY(r1.getY());
            }
        }.start();

        primaryStage.show();
    }
}
