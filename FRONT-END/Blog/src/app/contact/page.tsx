import ContactForm from '@/components/ContactForm';
import React from 'react';
import { AiFillGithub, AiFillLinkedin, AiFillYoutube } from 'react-icons/ai';
import { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'Contact Me',
  description: "CHUL에게 메일 보내기",
}

const LINKS = [
  { icon: <AiFillGithub />  , url: '' },
  { icon: <AiFillLinkedin />, url: '' },
  { icon: <AiFillYoutube /> , url: '' },
];

export default function ContactPage() {
  return (
    <section className='flex flex-col items-center'>
      <h2 className='text-3xl font-bold my-2'>나에게 연락하고 싶다면...</h2>
      <p>chul0425.j@gmail.com</p>
      <ul className='flex gap-4 my-2'>
        {LINKS.map((link, index) => (
          <a 
            key={index} 
            href={link.url} 
            className='text-5xl hover:text-pink-600' 
            target='_blank' 
            rel='noopener noreferrer'
          >{link.icon}
          </a>
        ))}
      </ul>
      <h2 className='text-3xl font-bold my-8'>이메일을 보내주세요.</h2>
      <ContactForm />
    </section>
  );
}

