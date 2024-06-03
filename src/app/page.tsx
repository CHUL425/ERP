import CarouselPosts from '@/components/CarouselPosts'
import FeaturePosts from '@/components/FeaturePosts'
import Hero from '@/components/Hero'
import Image from 'next/image'

export default function HomePage() {
  return (
    <>
      <Hero />
      <FeaturePosts />
      <CarouselPosts />
    </>
  )
}
