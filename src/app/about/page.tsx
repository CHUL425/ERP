import Hero from '@/components/Hero';
import React from 'react';
import { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'About Me',
  description: "CHUL's 자기 소개",
}

export default function AboutPage() {
  const TITLE_CLASSNAME = 'text-2xl font-bold text-gray-800 my-2';
  return (
    <>
      <Hero />
      <section className='bg-gray-100 shadow-lg p-8 m-8 text-center'>
        <h2 className={TITLE_CLASSNAME}>나는 누구인가? </h2>
        <p>
          프로그램 개발을 좋아하는 Full-stack개발자 <br />
          사람과 디자인을 담은 웹앱을 만들고 싶어요.
        </p>
        <h2 className={TITLE_CLASSNAME}>경력사항</h2>
        <p>미래에셋증권 ( ~ 근무 중 ) <br />
        KPMG 컨설팅 ( ~ 2000.05 )
        </p>
        <h2 className={TITLE_CLASSNAME}>보유 기술</h2>
        React.js, Next.JS, Vue.js(예정), XPlatform, Git <br />
        Spring Framework, Pro*C <br />
        Oracle, MySQL, MongoDB, MariaDB
      </section>
    </>
  );
}

