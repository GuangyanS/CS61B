public class Body {
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;
    public Body(double xP, double yP, double xV,
                double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Body(Body b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }
    public double calcDistance(Body b){
        return Math.sqrt(Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2));
    }
    public double calcForceExertedBy(Body b){
        double G = 6.67e-11;
        return G * this.mass * b.mass / Math.pow(calcDistance(b), 2);
    }
    public double calcForceExertedByX(Body b){
        return calcForceExertedBy(b) * (b.xxPos - this.xxPos) / calcDistance(b);
    }
    public double calcForceExertedByY(Body b){
        return calcForceExertedBy(b) * (b.yyPos - this.yyPos) / calcDistance(b);
    }
    public double calcNetForceExertedByX(Body[] bodies){
        double result = 0.0;
        for(Body b:bodies){
            if(b.equals(this)){
                System.out.println("Double Check Your Understanding.");
            }
            else {
                result += calcForceExertedByX(b);
            }
        }
        return result;
    }
    public double calcNetForceExertedByY(Body[] bodies){
        double result = 0.0;
        for(Body b:bodies){
            if(b.equals(this)){
                System.out.println("Double Check Your Understanding.");
            }
            else {
                result += calcForceExertedByY(b);
            }
        }
        return result;
    }
    public void update(double time, double x_force, double y_force) {
        double acce_x = x_force / this.mass, acce_y = y_force / this.mass;
        double new_xxVel = this.xxVel + time * acce_x, new_yyVel = this.yyVel + time * acce_y;
        this.xxPos += new_xxVel * time;
        this.yyPos += new_yyVel * time;
    }
    public void draw(){
        StdDraw.picture(xxPos, yyPos, imgFileName);
    }
}
