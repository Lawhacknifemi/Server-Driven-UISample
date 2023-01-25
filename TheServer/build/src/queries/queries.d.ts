export declare const queries: {
    Query: {
        sampleScreen: () => {
            elements: ({
                containerType: string;
                elements: {
                    typographyVariant: string;
                    value: string;
                    typographyTheme: string;
                }[];
            } | {
                containerType: string;
                elements: ({
                    formId: string;
                    placeholder: string;
                    icon?: undefined;
                    action?: undefined;
                    disabled?: undefined;
                    disableElevation?: undefined;
                    buttonTheme?: undefined;
                    buttonSize?: undefined;
                } | {
                    icon: string;
                    action: null;
                    disabled: boolean;
                    disableElevation: boolean;
                    buttonTheme: string;
                    buttonSize: string;
                    formId?: undefined;
                    placeholder?: undefined;
                })[];
            } | {
                containerType: string;
                elements: {
                    primaryText: string;
                    secondaryText: string;
                }[];
            } | {
                containerType: string;
                elements: {
                    chipLabel: string;
                }[];
            } | {
                containerType: string;
                elements: {
                    primary: string;
                    secondaries: string[];
                    links: never[];
                    media: {
                        url: string;
                        alt: string;
                    };
                }[];
            })[];
        };
    };
};
