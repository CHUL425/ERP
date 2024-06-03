import Image from 'next/image';
import { getAllPosts, getPostData } from '@/service/posts';
import PostContent from '@/components/PostContent';
import AdjacentPostCard from '@/components/AdjacentPostCard';
import { Metadata } from 'next';

type Props = {
  params: {
    slug: string;
  };
};

export async function generateMetadata(props: Props): Promise<Metadata> {
  const post = await getPostData(props.params.slug);

  return { 
    title      : post.title      ,
    description: post.description
  }
}

export default async function PostPage(props: Props) {
  // 1. 전달된 slug에 해당하는 포스트 데이터를 읽어옴.
  // console.log(props.params.slug);

  const post = await getPostData(props.params.slug);

  // 2. 데이터를 마크다운 뷰어에 표기.

  return (
    <article className='rounded-2xl overflow-hidden bg-gray-100 shadow-lg m-4'>
      <Image
        className = 'h-1/5 w-full max-h-[500px]'
        src = {`/images/posts/${post.path}.png`}
        alt = {post.title}
        width = '760'
        height = '420'
      />
    
      <PostContent post={post} />

      <section className='flex shadow-md font-bold'>
        {post.prevPost && <AdjacentPostCard post={post.prevPost} type='prev' />}
        {post.nextPost && <AdjacentPostCard post={post.nextPost} type='next' />}
      </section>
    </article>
  );
}

// slag에 적용한 페이지를 build 시점에 미리 만듬.
export async function generateStaticParams() {
  const posts = await getAllPosts();

  return posts.map((post) => ({
    slug: post.path,
  }))
}