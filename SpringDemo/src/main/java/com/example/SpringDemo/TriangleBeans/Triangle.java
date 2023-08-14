package com.example.SpringDemo.TriangleBeans;

import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unused")
public class Triangle {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    public void draw(){
        System.out.println("Point A = (" + getPointA().getX() +", " + getPointA().getY()+ ")" );
        System.out.println("Point B = (" + getPointB().getX() +", " + getPointB().getY()+ ")" );
        System.out.println("Point C = (" + getPointC().getX() +", " + getPointC().getY()+ ")" );
    }

    public Point getPointA() {
        return pointA;
    }
@Autowired
    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }
@Autowired
    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }
@Autowired
    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }
}
