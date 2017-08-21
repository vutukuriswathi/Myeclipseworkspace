package ABCGroupid.AppiumTests;

public class PythonTest {

	// Cloud URL (not including API path)
	String url = "";
	// Oauth access token
	String access_token = "";
	// Oauth refresh token
	String refresh_token="";

	// Unix timestamp (seconds) when token expires
	token_expiration_time="";

	// Full constructor with username and password"""

	PythonTest(username, password="", url="https://cloud.testdroid.com", download_buffer_size=65536)
	{
	        this.username = username;
	        this.password = password;
	        this.cloud_url = url;
	        this.download_buffer_size = download_buffer_size;
	}
	// Get Oauth2 token

	void get_token()
	{
	        if(!access_token)
	        {
	            // TODO: refresh
	            url = "%s/oauth/token" % this.cloud_url
	            payload = {
	                "client_id": "testdroid-cloud-api",
	                "grant_type": "password",
	                "username": this.username,
	                "password": this.password
	            }
	            res = requests.post(
	                                url,
	                                data = payload,
	                                headers = { "Accept": "application/json" }
	                                )
	            if res.status_code != 200:
	                print "FAILED: Authentication or connection failure. Check Testdroid Cloud URL and your credentials."
	                sys.exit(-1)

	            reply = res.json()

	            this.access_token = reply['access_token']
	            this.refresh_token = reply['refresh_token']
	            this.token_expiration_time = time.time() + reply['expires_in']
	        elif this.token_expiration_time < time.time():
	            url = "%s/oauth/token" % this.cloud_url
	            payload = {
	                "client_id": "testdroid-cloud-api",
	                "grant_type": "refresh_token",
	                "refresh_token": this.refresh_token
	            }
	            res = requests.post(
	                                url,
	                                data = payload,
	                                headers = { "Accept": "application/json" }
	                                )
	            if res.status_code != 200:
	                print "FAILED: Unable to get a new access token using refresh token"
	                this.access_token = None
	                return this.get_token()

	            reply = res.json()

	            this.access_token = reply['access_token']
	            this.refresh_token = reply['refresh_token']
	            this.token_expiration_time = time.time() + reply['expires_in']

	        return this.access_token
	}

	""" Helper method for getting necessary headers to use for API calls, including authentication"""

	def _build_headers(this):
	        return { "Authorization": "Bearer %s" % this.get_token(), "Accept": "application/json" }

	""" GET from API resource"""

	def get(this, path=None, payload={}, headers={}):
	        if path.find('v2/') >= 0:
	            cut_path = path.split('v2/')
	            path = cut_path[1]

	        url = "%s/api/v2/%s" % (this.cloud_url, path)
	        headers = dict(this._build_headers().items() + headers.items())
	        res =  requests.get(url, params=payload, headers=headers)
	        if headers['Accept'] == 'application/json':
	            return res.json()
	        else:
	            return res.text

	    """ Returns list of devices
	    """

	def get_devices(this, limit=0):
	        return this.get("devices?limit=%s" % (limit))

	    """ Find available free Android device
	    """

	def available_free_android_device(this, limit=0):
	        print "Searching Available Free Android Device..."

	        for device in this.get_devices(limit)['data']:
	            if device['creditsPrice'] == 0 and device['locked'] == False and device['osType'] == "ANDROID" and device['softwareVersion']['apiLevel'] > 16:
	                print "Found device '%s'" % device['displayName']
	                print ""
	                return str(device['displayName'])

	        print "No available device found"
	        print ""
	        return ""

	    """ Find available free iOS device
	    """

	def available_free_ios_device(this, limit=0):
	        print "Searching Available Free iOS Device..."

	        for device in this.get_devices(limit)['data']:
	            if device['creditsPrice'] == 0 and device['locked'] == False and device['osType'] == "IOS":
	                print "Found device '%s'" % device['displayName']
	                print ""
	                return str(device['displayName'])

	        print "No available device found"
	        print ""
	        return ""
	    """ Find out the API level of a Device
	    """

	def device_API_level(this,deviceName):print"Searching for API level of device %s"%deviceName

	try:device=this.get("devices", {
		'search':deviceName})apiLevel=device['data'][0]['softwareVersion']['apiLevel']print"Found API level: %s"%apiLevel return apiLevel except Exception,e:print"Error: %s"%e return
}
