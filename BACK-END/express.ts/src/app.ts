import express, { Express, Request, Response, NextFunction } from 'express';
import cookieParser from 'cookie-parser';
import cors from 'cors';
import morgan from 'morgan';
import helmet from 'helmet';
import 'express-async-errors';
//import tweetsRouter from './src/router/tweets.js';
//import authRouter from './src/router/auth.js';
import { initSocket } from './network/socket.js';
import { config } from './confing.js';

const app: Express = express();

const corsOption: cors.CorsOptions = {
  origin: config.cors.allowedOrigin,
  optionsSuccessStatus: 200,
  credentials: true,
};


app.use(express.json());
app.use(cookieParser());
app.use(helmet());
app.use(cors(corsOption));
app.use(morgan('tiny'));

//app.use('/tweets', tweetsRouter);
//app.use('/auth', authRouter);

app.use((req: Request, res: Response) => {
  console.log('Not Found !!!');
  res.sendStatus(404);
});

app.use((error: any, req: Request, res: Response, next: NextFunction) => {
  console.log(error);

  res.status(error.status || 500).json({
    message: error.message,
  });
});

console.log(config.cors.allowedOrigin);
console.log(`Server is started.... ${new Date()}`);

const expressServer = app.listen(config.port);
initSocket(expressServer);