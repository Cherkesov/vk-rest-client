# VK Client

Simple Jersey-based REST-client for Vkontakte API.

### How to

1. Get VK API access token 

    [Article about access token](https://vk.com/dev/implicit_flow_user) created with implicit flow.
    
    1. Open this link in browser:
    
            https://oauth.vk.com/authorize?client_id=YOUR_APP_ID&display=page&scope=offline,friends,groups&response_type=token&v=5.62&state=123456
    
    2. Press "Agree" button.
    
    3. Copy your token from redirected URL.