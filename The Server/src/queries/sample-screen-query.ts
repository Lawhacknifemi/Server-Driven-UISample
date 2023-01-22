export  const sampleScreenQuery = {
  sampleScreen : () =>{
    return{
      //  view elements
      elements: [
        {
          //container
          containerType : 'COLUMN',
          elements: [
            {
              typographyVariant: 'H3',
              value: 'Shop🛍️ cool Stuffs',
              typographyTheme: 'PRIMARY',
            },
            {
              typographyVariant: 'H3',
              value: 'that makes life easy!',
              typographyTheme: 'PRIMARY',
            },
          ],
        },
        {
          //  container
          containerType: 'ROW',
          elements: [
            //TextInput
            {
              formId: 'headingInput',
              placeholder: 'Search ...',
            },
            {
              icon: "notifications",
              action: null,
              disabled: false,
              disableElevation: false,
              buttonTheme: 'PRIMARY',
              buttonSize: 'MEDIUM',
            },
            {
              icon: "shopping cart",
              action: null,
              disabled: false,
              disableElevation: false,
              buttonTheme: 'PRIMARY',
              buttonSize: 'MEDIUM',
            }
          ]
        },
        {
          //container
          containerType: 'COLUMN',
          elements:[
            {
              //Banner
              primaryText: '10% off',
              secondaryText : 'Black Friday Surprise'
            }
          ]
        },
        {
          //  container
          containerType: 'ROW',
          elements: [
            {
              chipLabel: "Groceries"
            },
            {
              chipLabel: "Books"
            },
            {
              chipLabel: "Electronics"
            },
            {
              chipLabel: "RealEstate"
            },
          ]
        },
        {
          containerType: 'COLUMN',
          elements: [
            {
              typographyVariant: 'H3',
              value: 'Popular Items ⚡',
              typographyTheme: 'PRIMARY',
            }
          ]
        },
        {
          //container
          containerType: 'ROW',
          elements: [
            // Card
            {
              primary: 'Anabella',
              secondaries: ['Cat','$100'],
              links: [

              ],
              media: {
                url: 'https://loremflickr.com/640/400',
                alt: 'Random image',
              },
            },

            {
              primary: 'Lailah',
              secondaries: ['Cat','$70'],
              links: [

              ],
              media: {
                url: 'https://loremflickr.com/640/400',
                alt: 'Random image',
              },
            },
          ],
        },
      ]
    }
  }
}
