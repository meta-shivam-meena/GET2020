/**
 * TriangleService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.metacube.eadSession6_2;

public interface TriangleService extends javax.xml.rpc.Service {
    public java.lang.String getTriangleAddress();

    public com.metacube.eadSession6_2.Triangle getTriangle() throws javax.xml.rpc.ServiceException;

    public com.metacube.eadSession6_2.Triangle getTriangle(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
