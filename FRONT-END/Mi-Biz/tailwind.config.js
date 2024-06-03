/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{vue,js,ts,jsx,tsx}', './node_modules/flowbite/**/*.js'],
  theme: {
    extend: {
      fontFamily: {
        KoPubDotum_Pro_Medium: ['KoPubDotum_Pro_Medium'],
        KoPubDotum_Pro_Bold: ['KoPubDotum_Pro_Bold'],
        KoPubDotum_Pro_Light: ['KoPubDotum_Pro_Light']
      }
    }
  },
  plugins: [require('flowbite/plugin')]
};
