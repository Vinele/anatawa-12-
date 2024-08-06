package com.vinelles.custom_inv.network;

import com.vinelles.testmod.TestMod;
import com.vinelles.custom_inv.network.OpenInventoryMessage;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
 // Добавьте этот импорт

public class NetworkHandler {

    public static SimpleNetworkWrapper network;

    public static void init() {

        //инициализируем класс, что занимается передачей и обработкой пакетов между клиентом и сервером. TestMod.MOD_ID - айди мода.
        network = NetworkRegistry.INSTANCE.newSimpleChannel(TestMod.MODID);
        /*    Регистрируем пакет. Параметры: класс обработчика(статический класс, который лежит внутри OpenInventoryMessage),
              класс самого сообщения, идентификатор, сторона, на которой будет обрабатываться пакет.
              Так как мы посылаем его на сервер, для открытия GUI менно оттуда, то указываем Side.SERVER
        */
        network.registerMessage(OpenInventoryMessage.Handler.class, OpenInventoryMessage.class, 0, Side.SERVER);
    }
}