'use client';

import { useState } from 'react';
import PostGrid from './PostGrid';
import Categories from './Categories';
import { Post } from '@/service/posts';

type Props = {
  posts: Post[];
  categories: string[];
}
const ALL_POSTS = 'All Posts';


export default function FilterablePosts(props: Props) {
  const [selected, setSelected] = useState(ALL_POSTS);
  const filtered = (selected === ALL_POSTS) 
                   ? props.posts 
                   : props.posts.filter((post) => post.category === selected);

  return (
    <section className='flex gap-3 m-4'>
      <PostGrid posts={filtered} />
      <Categories 
        categories={[ALL_POSTS, ...props.categories]} 
        selected={selected} 
        onClick={setSelected} 
      />
    </section>
  );
}

