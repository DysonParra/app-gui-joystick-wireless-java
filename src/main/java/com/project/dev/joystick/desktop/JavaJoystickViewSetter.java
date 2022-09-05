/*
 * @fileoverview {FileName} se encarga de realizar tareas especificas.
 *
 * @version             1.0
 *
 * @author              Dyson Arley Parra Tilano <dysontilano@gmail.com>
 * Copyright (C) Dyson Parra
 *
 * @History v1.0 --- La implementacion de {FileName} fue realizada el 31/07/2022.
 * @Dev - La primera version de {FileName} fue escrita por Dyson A. Parra T.
 */
package com.project.dev.joystick.desktop;

import com.project.dev.joystick.factory.GenericImageAbstractFactory;
import com.project.dev.joystick.graphic.GraphicJoystick;
import com.project.dev.joystick.name.generic.GenericJoystick;
import com.project.dev.joystick.name.generic.setter.GenericJoystickGraphicSetter;
import com.project.dev.joystick.name.generic.type.GenericJoystickClient;
import com.project.dev.joystick.name.generic.type.GenericJoystickServer;
import com.project.dev.joystick.setter.GenericJoystickPrintActionSetter;
import com.project.dev.joystick.setter.JoystickViewSetter;
import javax.swing.JFrame;

import static com.project.dev.joystick.name.generic.GenericJoystick.JOYSTICK_TYPE_CLIENT;
import static com.project.dev.joystick.name.generic.GenericJoystick.JOYSTICK_TYPE_LOCAL;
import static com.project.dev.joystick.name.generic.GenericJoystick.JOYSTICK_TYPE_SERVER;

/**
 * TODO: Definición de {@code JavaJoystickViewSetter}.
 *
 * @author Dyson Parra
 * @since 1.8
 */
public class JavaJoystickViewSetter extends JoystickViewSetter<JFrame> {

    /**
     * FIXME: Definición de {@code JavaJoystickViewSetter}.
     *
     * @param view es la vista donde se agregará el joystick.
     */
    public JavaJoystickViewSetter(JFrame view) {
        super(view);
    }

    /**
     * FIXME: Definición de {@code addJoystickToView}. Asigna un joystick con su respectivo
     * asignador gráfico a la vista.
     *
     * @param joystick      es el joystick.
     * @param graphicSetter es el asignador de gráficos del joystick.
     * @return el joystick gráfico.
     * @throws java.lang.Exception Si ocurre un error.
     */
    @Override
    public GraphicJoystick addJoystickToView(GenericJoystick joystick, GenericJoystickGraphicSetter graphicSetter) throws Exception {
        GenericJoystickPrintActionSetter printActionSetter
                = new GenericJoystickPrintActionSetter();                                                   // Crea un asignador de acciones a los botones.

        GenericImageAbstractFactory imageFactory = new JavaGenericImageFactory();                       // Crea fábrica de imagenes genéricas de java.
        graphicSetter.setGenericJoystickGraphics(imageFactory, joystick);                               // Asigna gráficos al joystick.
        JavaGraphicJoystick graphicJoystick = new JavaGraphicJoystick(joystick);                        // Crea un joystick gráfico de java.
        if (!joystick.getType().equals(JOYSTICK_TYPE_SERVER))                                            // Si el joystick no es un servidor.
            graphicJoystick.addButtonKeyEvents();                                                       // agrega eventos de teclado al joystick.
        view.add(graphicJoystick);                                                                      // Agrega el joystick actual a la vista.

        graphicJoystick.scaleJoystickWidth(view.getWidth() - 10);

        switch (joystick.getType()) {                                                                   // Evalúa el tipo de joystick.
            case JOYSTICK_TYPE_CLIENT:                                                                  // Cliente.
                GenericJoystickClient client = (GenericJoystickClient) joystick;
                view.setTitle("Cliente "
                        + "IP: " + client.getServerIpAddress()
                        + "  Puerto: " + client.getServerPort());
                break;                                                                                  // Sale del case.

            case JOYSTICK_TYPE_SERVER:                                                                  // Servidor.
                GenericJoystickServer server = (GenericJoystickServer) joystick;
                view.setTitle("Servidor "
                        + "IP: " + server.getServerIpAddress()
                        + "  Puerto: " + server.getServerPort());
                printActionSetter.addButtonPrintActions(joystick);                                      // Agrega acciones de impresion en pantalla al joystick servidor.
                break;                                                                                  // Sale del case.

            case JOYSTICK_TYPE_LOCAL:                                                                   // Local.
                view.setTitle("Local");
                printActionSetter.addButtonPrintActions(joystick);                                      // Agrega acciones de impresion en pantalla al joystick local.
                break;                                                                                  // Sale del case.
        }

        return graphicJoystick;
    }
}
