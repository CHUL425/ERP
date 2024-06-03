import { link } from 'fs';

type Props = {
  categories: string[];
  selected  : string  ;
  onClick   : (category: string) => void;
}

export default function Categories(props: Props) {
  // console.log('Categories:',  props.categories);

  return (
    <section>
      <h2 className='text-lg font-bold border-b border-sky-500 mb-2'>
        Category
      </h2>
      <ul>
        {props.categories.map((category) => (
          <li 
            className={`cursor-pointer hover:text-sky-500 
              ${category === props.selected && 'text-sky-600'}`}
            key={category}
            onClick={() => props.onClick(category)}
          >
            {category}
          </li>
        ))}
      </ul>
    </section>
  );
}