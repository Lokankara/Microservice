### Quick Start

Get up and running with a single import.

```bash
npm install --save @emotion/react
```

```jsx
/** @jsx jsx */
import { jsx } from '@emotion/react'

let SomeComponent = props => {
  return (
    <div
      css={{
        color: 'hotpink'
      }}
      {...props}
    />
  )
}
```

### Do I Need To Use the Babel Plugin?

The babel plugin is not required, but enables some optimizations and customizations that could be beneficial for your project.

Look here 👉 _[emotion babel plugin feature table and documentation](https://github.com/emotion-js/emotion/tree/master/packages/babel-plugin)_

### Demo Sandbox

[Demo Code Sandbox](https://codesandbox.io/s/pk1qjqpw67)

### Examples

- [Introduction](https://emotion.sh/docs/introduction)
- [Install](https://emotion.sh/docs/install)
- [CSS Prop](https://emotion.sh/docs/css-prop)
- [Styled Components](https://emotion.sh/docs/styled)
- [Composition](https://emotion.sh/docs/composition)
- [Nested Selectors](https://emotion.sh/docs/nested)
- [Media Queries](https://emotion.sh/docs/media-queries)
