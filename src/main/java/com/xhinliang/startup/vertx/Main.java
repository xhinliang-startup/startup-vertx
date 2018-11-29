package com.xhinliang.startup.vertx;

import com.google.common.collect.ImmutableMap;
import com.xhinliang.startup.component.util.JsonMapperUtils;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;

/**
 * @author xhinliang <liangxuhua@kuaishou.com>
 * Created on 2018-11-29
 */
public class Main {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(40));
        HttpServer server = vertx.createHttpServer();

        server.requestHandler(request -> {

            // This handler gets called for each request that arrives on the server
            HttpServerResponse response = request.response();
            response.putHeader("Content-Type", "application/json");

            // Write to the response and end it
            response.end(JsonMapperUtils.toJSON(ImmutableMap.of("timestamp", System.currentTimeMillis())));
        });

        server.listen(8080);
    }
}
