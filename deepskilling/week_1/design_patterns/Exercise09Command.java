package deepskilling.week_1.design_patterns;

public class Exercise09Command {
    interface Command {
        void execute();
    }

    static class Light {
        void turnOn() {
            System.out.println("Light is on");
        }

        void turnOff() {
            System.out.println("Light is off");
        }
    }

    static class LightOnCommand implements Command {
        private final Light light;

        LightOnCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOn();
        }
    }

    static class LightOffCommand implements Command {
        private final Light light;

        LightOffCommand(Light light) {
            this.light = light;
        }

        public void execute() {
            light.turnOff();
        }
    }

    static class RemoteControl {
        private Command command;

        void setCommand(Command command) {
            this.command = command;
        }

        void pressButton() {
            command.execute();
        }
    }

    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl();
        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();
        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();
    }
}
