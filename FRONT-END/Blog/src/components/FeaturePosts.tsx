import { Post, getAllPosts, getFeaturedPosts } from '@/service/posts';
import PostGrid from './PostGrid';

export default async function FeaturePosts() {
  // 1. 모든 Post Data를 읽어와야 함.
  const posts: Post[] = await getFeaturedPosts();

  // 2. 모든 Post Data를 보여줌.

  return (
    <section className='my-4'>
      <h2 className='text-2xl font-bold my-2'>Feature Posts</h2>
      <PostGrid posts={posts} />
    </section>
  );
}

