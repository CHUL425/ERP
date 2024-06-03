'use client';

import React, { ChangeEvent, FormEvent, useState } from 'react';
import Banner, { BannerData } from './Banner';
import { sendContactEmail } from '@/service/contact';
import { error } from 'console';

type Form = {
  from   : string;
  subject: string;
  message: string;
};


const DEFAULT_DATA = {
  from   : '',
  subject: '',
  message: '',
}

export default function ContactForm() {
  const [emailForm, setEmailForm] = useState<Form>(DEFAULT_DATA);
  const [banner, setBanner] = useState<BannerData | null>(null);
  const onChange = (e: ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const {name, value} = e.target;
    setEmailForm((prev) => ({ ...prev, [name]: value }));
  }
  
  const onSubmit = (e: FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    console.log(emailForm);

    sendContactEmail(emailForm)
    .then (() => {
      setBanner({
        message: '메일을 성공적으로 보냈습니다.',
        state: 'success'
      });
      setEmailForm(DEFAULT_DATA);      
    })
    .catch((error) => {
      console.log('sendContactEmail:', error);
      setBanner({
        message: '메일 전송 실패 !!! 다시 시도해주세요.',
        state: 'fail'
      });
    })
    .finally(() => {
      setTimeout(() => {
        setBanner(null);
      }, 5000);
    });
  }

  return (
    <section className='w-full max-w-md'>
      {banner && <Banner banner={banner} />}
      <form onSubmit={onSubmit} className='w-full flex flex-col gap-2 my-4 p-4 bg-slate-700 rounded-xl text-white'>
        <label htmlFor="from" className='font-semibold'>보내는 사람 : </label>
        <input 
          className='text-black'
          type="email" 
          id='from'
          name='from'
          required
          autoFocus
          value={emailForm.from}
          onChange={onChange}
        />
        <label htmlFor="subject" className='font-semibold'>제목 : </label>
        <input 
          className='text-black'
          type="text" 
          id='subject'
          name='subject'
          required
          value={emailForm.subject}
          onChange={onChange}
        />
        <label htmlFor="message" className='font-semibold'>내용 : </label>
        <textarea 
          className='text-black'
          id='message'
          name='message'
          required
          value={emailForm.message}
          onChange={onChange}
        />
        <button className='bg-yellow-300 text-black font-bold hover:bg-yellow-400 p-1' >Submit</button>
  
      </form>
    </section>
  );
}
