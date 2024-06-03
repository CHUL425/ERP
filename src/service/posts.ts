import { readFile } from 'fs/promises';
import { cache } from 'react';
import path from 'path';

export type Post = {
  title      : string ;
  description: string ;
  date       : Date   ;
  category   : string ;
  path       : string ;
  featured   : boolean;
}

export type PostData = Post & { 
  content : string     ;
  nextPost: Post | null;
  prevPost: Post | null;
};

//export async function getAllPosts(): Promise<Post[]> {
  export const getAllPosts = cache( async () => {             // 중복실행 방지용 성능 개선
  const filePath = path.join(process.cwd(), 'data', 'posts.json');
  console.log('File경로 : ', filePath);

  return readFile (filePath, 'utf-8')
            .then <Post[]>((data) => JSON.parse(data))
            .then ((posts) => posts.sort((a, b) => (a.date > b.date ? -1 : 1)));

})

export async function getFeaturedPosts(): Promise<Post[]> {
  return getAllPosts () //
               .then ((posts) => posts.filter((post) => post.featured === true));
}

export async function getNonFeaturedPosts(): Promise<Post[]> {
  return getAllPosts () //
               .then ((posts) => posts.filter((post) => post.featured !== true));
}

export async function getPostData(fileName: string): Promise<PostData> {
  const filePath = path.join(process.cwd(), 'data', 'posts', `${fileName}.md`);
  //console.log(filePath);

  const posts = await getAllPosts ();
  const post  = posts.find((post) => (post.path === fileName));
  if (!post)
    throw new Error(`${fileName}을 찾을수 없음...`);

    const content = await readFile(filePath, 'utf-8');
    
    // posts 배열에서 현재의 post데이터의 index 를 구한다. index값의 +- 를 통해 이전, 이후 데이터를 복사한다.
  // index값이 0보다 크면 이전 데이터 존재, index값이 배열보다 작으면 다음 데이터 존재
  // 배열의 길이를 구하고 index 값과 비교시 -1한값과 비교. --> 배열의 index 는 0부터 시작
  const currIndex = posts.indexOf(post);  
  const nextPost  = currIndex < posts.length-1 ? posts[currIndex+1] : null; 
  const prevPost  = currIndex > 0 ? posts[currIndex-1] : null; 
  
  return { ...post, content, nextPost, prevPost};
}