import jwt                from 'jsonwebtoken';
import { Server, Socket } from 'socket.io';
import { config } from '../confing.js';


class ExpressSocket {
  public io: Server;

  constructor(expressServer: any) {
    this.io = new Server(expressServer, {
      cors: {
        origin: config.cors.allowedOrigin,
      },
    });

    this.io.use((socket: Socket, next: (err?: Error) => void) => {
      const token: string = socket.handshake.auth.token;
      if (!token) {
        return next(new Error('Authentication Error'));
      }

      jwt.verify(token, config.jwt.secretKey, (error: jwt.VerifyErrors | null, decoded: any) => {
        if (error) {
          return next(new Error('Authentication Error'));
        }
        console.log('ExpressSocket class decoded:', decoded);
        next();
      });
    });

    this.io.on('connection', (socket: Socket) => {
      console.log('ExpressSocket client Connected....', socket);
    });
  }
}

let socket: ExpressSocket | undefined;
export function initSocket(server: any) {
  if (!socket) {
    socket = new ExpressSocket(server);
  }
}

export function getSocketIO() {
  if (!socket) {
    throw new Error('Please call init first');    
  }

  return socket.io;
}