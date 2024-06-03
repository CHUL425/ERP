import nodemailer from 'nodemailer';
import { config } from '../../config';

export type EmailData = {
  from   : string;
  subject: string;
  message: string;
};

const transporter = nodemailer.createTransport({
    service: config.email.service,
    host   : config.email.host   ,
    port   : config.email.port   ,
    secure : config.email.secure ,
    auth   : {
      user: config.email.auth_user    ,
      pass: config.email.auth_password,
  },
  tls: {
    rejectUnauthorized: false
  }  
});

export async function sendEmail(mailData: EmailData) {
  const sendData = {
    from   : mailData.from                     ,
    to     : config.email.auth_user            ,
    subject: `[BLOG] ${mailData.subject}`      ,
    text   : mailData.message                  ,
    html   : `<h1>${mailData.subject}</h1>
              <div>${mailData.message}</div>
              <br/>
              <p>보낸사람: ${mailData.from}</p>`,
  };

  return transporter.sendMail(sendData);
}
