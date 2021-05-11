# Goal

Build an app that displays a (endless) list of photos. Clicking a photo goes to a detail screen for it. It can be deleted or turned into greyscale from there. 

We will be using the Lorem Picsum API found [here](https://picsum.photos/). We will be using the list endpoint as our data source. Note that it also supports turning an image into greyscale by appending a url parameter.

The app has a few things to get started. It is using Volley and Gson for request and parsing and Glide for displaying images. `APIHelper` and `PicsumInfo` are there to get started with. `APIHelper#getList` will start you off getting a list of images. Note that this is only implemented to get the first page.

The rough mockups are below. You may need to handle a few UI components yourself depending on your implementation.

# Project Links

**Kotlin**: [https://github.com/jondh/AuraAndroidKotlin](https://github.com/jondh/AuraAndroidKotlin)
**Java**: [https://github.com/jondh/AuraAndroidJava](https://github.com/jondh/AuraAndroidJava)

see https://www.notion.so/pushd/Android-On-site-Interview-Candidate-27355d1715174c61afd5248d8a52ab11 for details
