'use strict';

const WebSocket = require('ws');
const express = require('express');
const http = require('http');

const app = express();
const server = http.createServer();

const wss = new WebSocket.Server({ 
  server: server 
});

// Func pra fazer broadcast pra todos clients
wss.broadcast = function broadcast(data) {
  wss.clients.forEach(function each(client) {
    if (client.readyState === WebSocket.OPEN) {
      client.send(data);
    }
  });
};

app.get('/', (req, res) => {
  res.send('Um site maneirão');
  wss.broadcast('Uma pessoa conectou no site');
})

wss.on('connection', (ws) => {
  console.log('ws connected');
  ws.send('Hello');
});

server.on('request', app);

const port = process.env.PORT || 3000;

server.listen(port, () => {
  console.log('Listening on ' + port);
});

