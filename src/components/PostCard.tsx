import { Post } from '@/service/posts';
import Image from 'next/image';
import Link from 'next/link';

type Props = {
  post: Post  ;
};

export default function PostCard(props: Props) {
  // console.log(props.post.path);

  return (
    <Link href={`/posts/${props.post.path}`}>
      <article className='rounded-md overflow-hidden shadow-md hover:shadow-xl'>
        <Image
          className = 'w-full'
          src = {`/images/posts/${props.post.path}.png`}
          alt = {props.post.title}
          width = {300}
          height = {200}
        />
        <div className='flex flex-col items-center p-4'>
          <time className='self-end text-gray-700'>{props.post.date.toString()}</time>
          <h3 className='text-lg font-bold'>{props.post.title}</h3>
          <p className='w-full truncate text-center'>{props.post.description}</p>
          <span className='text-sm rounded-lg bg-green-100 px-2 my-2'>{props.post.category}</span>
        </div>

      </article>
    </Link>
  );
}

