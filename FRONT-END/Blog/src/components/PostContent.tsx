import MarkdownViewer from '@/components/MarkdownViewer';
import { AiFillCalendar } from "react-icons/ai";
import { PostData } from '@/service/posts';

type Props = {
  post: PostData; 
}

export default function PostContent(props: Props) {
  return (
    <section className='flex flex-col p-4'>
      <div className='flex items-center self-end text-sky-600'>
        <AiFillCalendar />
        <p className='font-semibold ml-2'>{props.post.date.toString()}</p>
      </div>
      <h1 className='text-4xl font-bold'>{props.post.title}</h1>
      <p className='text-xl font-bold'>{props.post.description}</p>
      <div className='w-44 border-2 border-sky-600 mt-4 mb-8'></div>
      <MarkdownViewer content={props.post.content} />
    </section>  );
}

