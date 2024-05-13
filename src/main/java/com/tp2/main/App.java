package com.tp2.main;

//aqui importo las clases necesarias para poder hacer el programa
import com.tp2.main.model.*;
import com.tp2.main.repository.*;

public class App 
{
    public static void main( String[] args )
    {
        //aqui creo el banco
        Banco banco = new Banco("Macro");
        InterfazMenu menu = new InterfazMenu();

        menu.renderMenu(banco);
    }
}
