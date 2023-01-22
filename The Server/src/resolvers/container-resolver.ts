export const containerResolver = {
  ContainerElement :{
    __resolveType(obj: any){
      if (obj.typographyVariant && obj.value) {
        return 'Typography';
      }

      if (obj.primaryText && obj.secondaryText){
        return 'Banner'
      }

      if (obj.width || obj.height) {
        return 'Box';
      }

      if (obj.buttonVariant && obj.label) {
        return 'Button';
      }
      if (obj.url && obj.alt) {
        return 'Image';
      }
      if (obj.placeholder || obj.formId){
        return 'TextInput'
      }
      if (obj.primary) {
        return 'Card';
      }
      if (obj.chipLabel){
        return 'Chip'
      }
      if (obj.icon){
        return  'IconButton'
      }
      return  null
    }

  }
}
