import java.util.ArrayList;

public class NBody {
    public static double readRadius(String filename){
        In in = new In(filename); // From examples/BasicInDemo.java
        in.readInt(); // Ignore the first number N
        return in.readDouble();
    }
    public static Planet[] readPlanets(String filename){
        // TODO Not robust enough if we have planet numbers other than 5
        In in = new In(filename);
        in.readInt(); in.readDouble();
        Planet[] bodies = new Planet[5];;
        for(int i = 0; i < 5; i++){
            bodies[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return bodies;
    }
    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] bodies = readPlanets(filename);

        // Create an xForces array and yForces array.
        double[] xForces = new double[5];
        double[] yForces = new double[5];

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        for(double time=0.0; time <= T; time += dt){
            // Calculate the net x and y forces for each Body,
            // storing these in the xForces and yForces arrays respectively.
            for(int i = 0; i < 5; i++){
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            // After calculating the net forces for every Body, call update on each of the Bodys.
            // This will update each body’s position, velocity, and acceleration.
            for(int i = 0; i < 5; i++){
                 bodies[i].update(dt, xForces[i], yForces[i]);
            }
            // Draw the background image
            StdDraw.picture(0, 0, "images/starfield.jpg");
            // Draw all of the Body s.
            for(int i = 0; i < 5; i++){
                StdDraw.picture(bodies[i].xxPos, bodies[i].yyPos, "images/" + bodies[i].imgFileName);
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdDraw.clear();
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}
