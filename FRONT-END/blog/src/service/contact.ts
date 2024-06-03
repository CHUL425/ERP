import { EmailData } from './email';


export async function sendContactEmail(emailData: EmailData) {
  const res = await fetch('/api/contact', {
    method : 'POST'                                ,
    body   : JSON.stringify(emailData)             ,
    headers: {'Content-Type': 'applicatioin/json',},
  });

  
  const data = await res.json();
  console.log('data : ', data)

  if (!res.ok) {
    throw new Error(data.message || '서버 요청에 실패함 😂');
  }

  return data;
}
