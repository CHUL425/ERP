import FilterablePosts from '@/components/FilterablePosts';
import { getAllPosts } from '@/service/posts';
import React from 'react';
import { Metadata } from 'next';

export const metadata: Metadata = {
  title: 'All Post',
  description: "Blog 관련 소개 글",
}

export default async function PostsPage() {
  const posts = await getAllPosts();
  const categories = [...new Set(posts.map((post) => post.category))];
  // console.log(categories);

  return <FilterablePosts posts={posts} categories={categories} />
}

